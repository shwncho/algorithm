import java.util.*;
class Genre implements Comparable<Genre>{
    public String genre;
    public int sum;

    Genre(String genre, int sum){
        this.genre = genre;
        this.sum = sum;
    }

    @Override
    public int compareTo(Genre o){
        return o.sum - this.sum;
    }
}
class Music implements Comparable<Music>{
    public int play,idx;

    Music(int play, int idx){
        this.play = play;
        this.idx = idx;
    }

    @Override
    public int compareTo(Music o){
        if(this.play == o.play) return this.idx - o.idx;
        return o.play - this.play;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> genreSum = new HashMap<>();
        Map<String, List<Music>> genreMap = new HashMap<>();
        List<Genre> genreList = new ArrayList<>();

        for(int i=0; i<plays.length; i++){
            genreSum.put(genres[i], genreSum.getOrDefault(genres[i],0)+plays[i]);
        }

        for(String genre : genreSum.keySet()){
            genreMap.put(genre,new ArrayList<>());
            genreList.add(new Genre(genre, genreSum.get(genre)));
        }


        for(int i=0; i<plays.length; i++){
            genreMap.get(genres[i]).add(new Music(plays[i],i));
        }

        for(String genre : genreMap.keySet()){
            Collections.sort(genreMap.get(genre));
        }

        Collections.sort(genreList);

        List<Integer> result = new ArrayList<>();
        for(Genre g : genreList){
            if(genreMap.get(g.genre).size()==1){
                result.add(genreMap.get(g.genre).get(0).idx);
            }
            else{
                result.add(genreMap.get(g.genre).get(0).idx);
                result.add(genreMap.get(g.genre).get(1).idx);
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}