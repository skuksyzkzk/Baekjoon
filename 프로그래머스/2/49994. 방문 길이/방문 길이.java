import java.util.*;

class Solution {
    static int x;
    static int y;
    
    public int solution(String dirs) {
        int answer = 0;
        char[] inputs = dirs.toCharArray();
        HashSet<String> set = new HashSet<>();
        x = 0 ; 
        y = 0 ;
        // 들어온 인풋 만큼 수행 
        for (int i = 0 ;  i < inputs.length; i++ ){
            // U 위는 6되면 거부하기
            int nx = 0; 
            int ny = 0;
            if (inputs[i] == 'U' && (y+1) < 6){
                ny = y+1;
                set.add(x+"-"+y+" to "+x+"-"+ny);
                set.add(x+"-"+ny+" to "+x+"-"+y);
                y++;
            }
            // D 아래는 -6되면 거부하기 
            else if (inputs[i] == 'D' && (y-1) > -6){
                ny = y-1;
                set.add(x+"-"+y+" to "+x+"-"+ny);
                set.add(x+"-"+ny+" to "+x+"-"+y);
                y--;
            }
            // L 왼쪽은 -6되면 거부하기
            else if (inputs[i] == 'L' && (x-1) > -6){
                nx = x-1;
                set.add(x+"-"+y+" to "+nx+"-"+y);
                set.add(nx+"-"+y+" to "+x+"-"+y);
                x--;
            }
            // R 오른쪽은 6되면 거부하기
            else if (inputs[i] == 'R' && (x+1) < 6){
                nx = x+1;
                set.add(x+"-"+y+" to "+nx+"-"+y);
                set.add(nx+"-"+y+" to "+x+"-"+y);
                x++;
            }
        }
        
        return set.size() / 2 ;
    }
}