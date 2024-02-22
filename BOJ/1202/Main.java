import java.io.*;
import java.util.*;
public class Main {
    static class Jewelry implements Comparable<Jewelry>{
        int w,v;
        Jewelry(int w, int v){
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry o) {
            if(this.w == o.w)   return o.v - this.v;
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewelry> jewelries = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelries.add(new Jewelry(w,v));
        }

        List<Integer> bags = new ArrayList<>();
        for(int i=0; i<K; i++){
            int w = Integer.parseInt(br.readLine());
            bags.add(w);
        }
        Collections.sort(bags);
        Collections.sort(jewelries);

        long answer = 0;
        int idx = 0;
        PriorityQueue<Long> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<K; i++){
            while(idx<N && jewelries.get(idx).w<=bags.get(i)) pQ.offer((long)jewelries.get(idx++).v);
            if(!pQ.isEmpty()){
                answer+=pQ.poll();
            }
        }
        System.out.println(answer);
    }
}
