import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0;i < record.length;i++){
            String[] s = record[i].split(" ");
            if (s[0].equals("Enter") || s[0].equals("Change")) {
                map.put(s[1],s[2]);
            }
        }
        for (int i = 0; i< record.length;i++){
            String[] s = record[i].split(" ");
            if (s[0].equals("Enter")){
                list.add(map.get(s[1]) + "님이 들어왔습니다.");
            }
            else if (s[0].equals("Leave")){
                list.add(map.get(s[1]) + "님이 나갔습니다.");
            }
            
        }
        return list.stream().toArray(String[]::new);
    }
}