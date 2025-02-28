import java.util.*;

class Solution {
    // 문제 정보를 담는 클래스 (파이썬의 namedtuple 역할)
    static class Problem {
        int cost;     // 문제 풀이(또는 공부) 시간/비용
        int nalp;     // 문제 요구 알고력
        int ncop;     // 문제 요구 코딩력
        int ralp;     // 이 문제를 풀었을 때(또는 공부 시) 얻는 알고력 증가치
        int rcop;     // 이 문제를 풀었을 때(또는 공부 시) 얻는 코딩력 증가치
        
        public Problem(int cost, int nalp, int ncop, int ralp, int rcop) {
            this.cost = cost;
            this.nalp = nalp;
            this.ncop = ncop;
            this.ralp = ralp;
            this.rcop = rcop;
        }
    }
    
    // (상태) : 알고력, 코딩력
    // 다익스트라 우선순위 큐에 들어갈 요소
    static class State implements Comparable<State> {
        int cost;  // 지금까지 걸린 시간/비용
        int alp;
        int cop;
        
        public State(int cost, int alp, int cop) {
            this.cost = cost;
            this.alp = alp;
            this.cop = cop;
        }

        // 비용이 작은 순으로 우선순위
        @Override
        public int compareTo(State other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public int solution(int alp, int cop, int[][] problems) {
        // 문제 정보를 Problem 리스트로 변환
        ArrayList<Problem> problemList = new ArrayList<>();
        for (int[] p : problems) {
            int nalp = p[0];
            int ncop = p[1];
            int ralp = p[2];
            int rcop = p[3];
            int cost = p[4];
            problemList.add(new Problem(cost, nalp, ncop, ralp, rcop));
        }
        
        // 공부해서 +1 alp or +1 cop 하는 "가상의 문제" 2개 추가
        // cost=1, 요구사항=0, 보상=(1,0)/(0,1)
        problemList.add(new Problem(1, 0, 0, 1, 0));
        problemList.add(new Problem(1, 0, 0, 0, 1));
        
        // 필요한 최대치 계산
        int maxAlp = 0;
        int maxCop = 0;
        for (Problem p : problemList) {
            maxAlp = Math.max(maxAlp, p.nalp);
            maxCop = Math.max(maxCop, p.ncop);
        }
        
        // 다익스트라용 자료구조
        // dist: (alp, cop) 상태 -> 최솟값
        // 자바에서는 (alp, cop) 두 정수를 하나의 Key로 쓰기 위해 Map 사용
        Map<String, Integer> dist = new HashMap<>();
        
        // 시작 상태 (alp, cop)에서 비용=0
        // 만약 시작 alp나 cop가 이미 maxAlp / maxCop보다 크면 오버되는 부분은 필요없으니 min으로 보정
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        String startKey = alp + "," + cop;
        dist.put(startKey, 0);
        
        // 우선순위 큐 (최소 힙)
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(0, alp, cop));
        
        // 방문 여부 (이미 최소 비용으로 확정된 상태는 재처리 X)
        // 파이썬 예시는 visited 세트 사용
        Set<String> visited = new HashSet<>();
        
        // 다익스트라 진행
        while (!pq.isEmpty()) {
            State st = pq.poll();
            int curCost = st.cost;
            int curAlp = st.alp;
            int curCop = st.cop;
            
            String curKey = curAlp + "," + curCop;
            if (visited.contains(curKey)) {
                continue; 
            }
            visited.add(curKey);
            
            // 만약 (curAlp, curCop)가 목표에 도달했다면 바로 dist 반환 가능
            // 하지만 여기서는 꼭 pq에서 뽑힌 시점이 아니라도,
            // 최종적으로 dist[(maxAlp, maxCop)]가 필요하므로 그냥 진행해도 무방
            // if (curAlp == maxAlp && curCop == maxCop) { return curCost; }
            
            // 모든 문제(및 "공부") 시도
            for (Problem p : problemList) {
                // 요구사항 만족 시
                if (curAlp >= p.nalp && curCop >= p.ncop) {
                    // 새 상태
                    int newAlp = Math.min(maxAlp, curAlp + p.ralp);
                    int newCop = Math.min(maxCop, curCop + p.rcop);
                    int newCost = curCost + p.cost;
                    
                    String newKey = newAlp + "," + newCop;
                    
                    // dist 갱신
                    int prevCost = dist.getOrDefault(newKey, Integer.MAX_VALUE);
                    if (newCost < prevCost) {
                        dist.put(newKey, newCost);
                        pq.offer(new State(newCost, newAlp, newCop));
                    }
                }
            }
        }
        
        // dist에서 (maxAlp, maxCop) 상태의 비용을 반환
        // PQ가 다 끝났다면 dist에는 최솟값이 저장되어 있을 것
        String goalKey = maxAlp + "," + maxCop;
        return dist.getOrDefault(goalKey, 0);
    }
}
