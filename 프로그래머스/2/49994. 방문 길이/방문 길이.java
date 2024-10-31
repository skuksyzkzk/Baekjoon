import java.util.*;

class Solution {
    public static boolean isIn(int x,int y) {
        return x >= 0 && x < 11 && y >= 0 && y <11;
    }
    public int solution(String dirs) {
        int answer = 0;
        Map<Character,int[]> map = new HashMap<>();
        
        map.put('U',new int[]{-1,0});
        map.put('D',new int[]{1,0});
        map.put('R',new int[]{0,1});
        map.put('L',new int[]{0,-1});
        int x = 5;int y = 5;
        Set<String> set = new HashSet<>();
        for (int i = 0; i<dirs.length();i++){
            int[] move = map.get(dirs.charAt(i));
            int nx = x + move[0];
            int ny = y + move[1];
            if (!isIn(nx,ny)) continue;
            set.add(x+""+y+","+nx+""+ny);
            set.add(nx+""+ny+","+x+""+y);
            x = nx;
            y = ny;
        }
        return set.size() / 2;
    }
}