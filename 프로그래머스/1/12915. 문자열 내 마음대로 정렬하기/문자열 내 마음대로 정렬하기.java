import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Str[] strs = new Str[strings.length];
        for (int i = 0;i<strings.length;i++){
            char ret = strings[i].charAt(n);
            strs[i] = new Str(strings[i],Character.toString(ret));
        }
        Arrays.sort(strs,comp);
        String[] answer = new String[strings.length];
        for (int i =0;i<strings.length;i++){
            answer[i] = strs[i].str;
        }
        return answer;
    }
    public static Comparator<Str> comp = new Comparator<Str>() {
        @Override
        public int compare(Str o1,Str o2){
            if (o1.idx.equals(o2.idx)){
                return o1.str.compareTo(o2.str);
            }
            return o1.idx.compareTo(o2.idx);
        }
    };
}
class Str {
    String str;
    String idx;
    public Str(String str,String idx){
        this.str = str;
        this.idx = idx;
    }
}