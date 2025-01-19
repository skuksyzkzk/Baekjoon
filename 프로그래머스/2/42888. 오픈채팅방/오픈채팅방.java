import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        
        for (int i = 0 ; i< record.length ;i++) {
            String[] inputs = record[i].split(" ");
            if (inputs[0].equals("Enter") ||inputs[0].equals("Change")){
                map.put(inputs[1],inputs[2]);
            }     
        }
        for (int i = 0 ; i< record.length ;i++) {
            String[] inputs = record[i].split(" ");
            if (inputs[0].equals("Enter") ){
                answer.add(map.get(inputs[1])+"님이 들어왔습니다.");
            } 
            else if (inputs[0].equals("Leave")){
                answer.add(map.get(inputs[1])+"님이 나갔습니다.");
            }
        }
        return answer.stream().toArray(String[]::new);
    }
}