import java.util.*;

class Solution {
    class Stage implements Comparable<Stage>{
        int number;
        double percent;
        public Stage(int number,double percent){
            this.number = number;
            this.percent = percent;
        }
        @Override
        public int compareTo(Stage other){
            if (Double.compare(this.percent,other.percent) == 0) {
                return Integer.compare(this.number,other.number);
            }
            return Double.compare(other.percent,this.percent);
        }
    }
    // 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 옴 
    // 스테이지에 도달한 유저가 없다면 실패율 0으로 정의
    
    public int[] solution(int N, int[] stages) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 실패율이 높은 스테이지 부터 내림 차순으로 스테이지 번호 return 
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        Arrays.sort(stages);
        int total = stages.length;
        int[] dist = new int[N+1];
        // stages 배열을 차라리 내림차순으로 정렬한다음 
        // stages 보다 큰 수가 나오면 index 계산 멈추기 index / Stages.length
        for (int i = 1; i <= N; i++){
            int sol = binarySearchUpper(stages,i);
            dist[i] = sol;
            int diff = (dist[i] - dist[i-1]);
            // 실패를 안한 것
            if (diff == 0) {
                pq.add(new Stage(i,0));
            }
            else {
                double pct = (double) diff / total;
                pq.add(new Stage(i,pct));
            }
            total -= diff;
            
        }
        while (!pq.isEmpty()){
            Stage cur = pq.poll();
            answer.add(cur.number);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public int binarySearchUpper(int[] arr,int find){
        int left = 0 ; int right = arr.length;
        while (left < right){
            int mid = (left+right) / 2 ;
            if (arr[mid] > find) right = mid;
            else if (arr[mid] <= find) left = mid+1;
        }
        return left;
    }
}