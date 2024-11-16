import java.io.*;
import java.util.*;
public class Main {
    static class Word implements Comparable<Word>{
        String word;
        int cnt;

        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if(this.cnt != o.cnt)   return o.cnt - this.cnt;
            if(this.word.length() != o.word.length()) return o.word.length()- this.word.length();

            return this.word.compareTo(o.word);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length() < M)   continue;
            map.put(word,map.getOrDefault(word,0)+1);
        }

        Queue<Word> q = new PriorityQueue<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            q.add(new Word(entry.getKey(),entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.poll().word).append("\n");
        }

        System.out.println(sb);
    }
}
