import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0 ; i < commands.length; i++){
            int st = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            ArrayList<Integer> save = new ArrayList<>();
            for ( int j = st-1; j < end ; j++ ){
                save.add(array[j]); 
            }
            Collections.sort(save);
            int added = save.get(k-1);
            answer.add(added);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}