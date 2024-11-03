import java.util.*;

class Solution {
    class Song {
        int number;
        int plays;
        
        public Song(int number,int plays){
            this.number = number;
            this.plays = plays;
        }
    }
    static Comparator<Song> comp  = new Comparator<Song> () {
        
        @Override
        public int compare(Song a, Song b){
            if (a.plays == b.plays) return a.number - b.number;
            return b.plays - a.plays;
        }
        
    };
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        // 인기 장르 고르기 
        for (int i = 0; i < genres.length;i++){
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }
        // 내림차순 정리 
        ArrayList<Map.Entry<String, Integer>> arr = new ArrayList<>(map.entrySet());
        
        Collections.sort(arr, (a,b) -> {
            return Integer.compare(b.getValue(),a.getValue());
        });
        
        for (int i = 0 ; i < map.size(); i ++){
            String genre = arr.get(i).getKey();
            List<Song> cur = new ArrayList<>();
            for (int st = 0; st < genres.length; st++){
                if (genre.equals(genres[st])){
                    Song temp = new Song(st,plays[st]);
                    cur.add(temp);
                }
            }
            Collections.sort(cur,comp);
            if (cur.size() < 2){
                answer.add(cur.get(0).number);
            }else {
                answer.add(cur.get(0).number);
                answer.add(cur.get(1).number);
            }
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}