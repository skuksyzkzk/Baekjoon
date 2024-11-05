import java.util.*;

class Solution {
    private static HashMap<Integer, HashMap<String,Integer>> courseToMenus = 
        new HashMap<>();
    
    private static void combination(int start,char[] arr,String result){
        if (courseToMenus.containsKey(result.length())){
            HashMap<String,Integer> temp = courseToMenus.get(result.length());
            temp.put(result,temp.getOrDefault(result,0) + 1);
        }
        for (int i = start; i < arr.length;i++){
            combination(i+1,arr,result+arr[i]);
        }
    };
    public String[] solution(String[] orders, int[] course) {
        courseToMenus = new HashMap<>();
        for (int i : course) {
            courseToMenus.put(i,new HashMap<>());
        }
    
        for (String s : orders) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            combination(0,charArr,"");
        }
        ArrayList<String> answer = new ArrayList<>();
        
        // 많이 나온 조합 
        for (HashMap<String,Integer> count : courseToMenus.values()){
            int maxValue = 0;
            
            for (int i : count.values()){
                if (i > maxValue) maxValue = i;
            }
            if (maxValue >1){
                for (Map.Entry<String,Integer> entry : count.entrySet()){
                    if (entry.getValue() == maxValue)
                        answer.add(entry.getKey());
                }   
            }
            
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
}