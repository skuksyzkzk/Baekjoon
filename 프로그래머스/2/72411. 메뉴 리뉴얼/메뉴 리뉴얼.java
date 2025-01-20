import java.util.*;

class Solution {
    public static String[] order;
    public static TreeSet<String> set;
    public static TreeSet<String> answer;
    public static HashMap<String,Integer> map;
    public static String[] print;
    // 조합 
    public void combination(int start,int now , int n){
        // 탈출조건 n이면 
        if (now == n ){
            String[] temp = Arrays.copyOf(print, n);
            Arrays.sort(temp); // 조합된 문자열을 정렬
            String ret = String.join("", temp); // 정렬된 문자열로 생성

            if (set.contains(ret)) {
                map.put(ret,map.getOrDefault(ret,0)+1);
            }
            else set.add(ret);
            
            return;
        }
        for (int i = start ; i < order.length;i++){
            print[now] = order[i];
            combination(i+1,now+1,n);
        }
        
    }
    public String[] solution(String[] orders, int[] course) {
        answer = new TreeSet<>();
        set = new TreeSet<>();
        map = new HashMap<>();
        
        for (int i = 0 ; i < orders.length; i++){
            // 메뉴 배열로 리턴 
            order = orders[i].split("");
            // course 만큼
            for (int idx = 0 ; idx < course.length; idx++){
                // course의 수가 선택한 메뉴의 수보다 작거나 같을 경우에 대해서 조합진행
                if (course[idx] <= order.length) {
                    print = new String[course[idx]];
                    combination(0,0,course[idx]);
                }
            }
        }
        // 최종 Map에는 2번이상 나오게 된 메뉴들이 존재 
        for (int len : course){
            int maxCount = 1;
            for (Map.Entry<String,Integer> entry : map.entrySet()){
                if ( entry.getKey().length() == len ) {
                    maxCount = Math.max(maxCount,entry.getValue());
                }
            }
            for (Map.Entry<String,Integer> entry : map.entrySet()){
                if ( entry.getKey().length() == len && entry.getValue() == maxCount){
                    answer.add(entry.getKey());
                }
            }
        }
    
        return answer.stream().distinct().toArray(String[]::new);
    }
}