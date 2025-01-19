import java.util.*;

class Solution {
    // 필요한 속성: 장르, 재생수 , 고유 번호 
    class Song implements Comparable<Song> {
        String genre;
        int play;
        int number;
        
        public Song (String genre,int play,int number){
            this.genre = genre;
            this.play = play;
            this.number = number;
        }
        @Override
        public int compareTo(Song other){
            // 플레이 수가 같으면 고유번호가 낮은거 먼저
            if (this.play == other.play){
                return Integer.compare(this.number,other.number);
            }
            return Integer.compare(other.play,this.play);
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,ArrayList<Song>> list = new HashMap<>();
        // 장르의 플레이수 합 구하기
        for (int i = 0 ; i < genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
            
            list.putIfAbsent(genres[i], new ArrayList<>());
            list.get(genres[i]).add(new Song(genres[i],plays[i],i));
        }
        // 장르의 우선순위 정렬 
        PriorityQueue<Song> sortedGenres = new PriorityQueue<>();
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            sortedGenres.add(new Song(entry.getKey(),entry.getValue(),-1));
        }
        
        while (!sortedGenres.isEmpty()){
            Song cur = sortedGenres.poll();
            
            ArrayList<Song> songs = list.get(cur.genre);
            Collections.sort(songs);
            
            for (int i = 0 ; i < Math.min(2,songs.size()); i++){
                answer.add(songs.get(i).number);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}