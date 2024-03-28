import java.util.*;
import java.io.*;
public class Main {

    static class Bucket{
        public int a,b,cnt;
        Bucket(int a, int b, int cnt){
            this.a=a;
            this.b=b;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Bucket bucket = (Bucket) o;

            if (a != bucket.a) return false;
            if (b != bucket.b) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a,b);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Queue<Bucket> q = new LinkedList<>();
        q.offer(new Bucket(0,0,0));
        int answer = Integer.MAX_VALUE;
        Map<Bucket,Integer> visited = new HashMap<>();

        while(!q.isEmpty()){

            Bucket tmp = q.poll();

            if(visited.containsKey(tmp))   continue;

            visited.put(new Bucket(tmp.a,tmp.b,0),tmp.cnt);

            if(tmp.a==c && tmp.b==d)    answer = Math.min(answer, tmp.cnt);

            //Fill a
            if(tmp.a!=a)    q.offer(new Bucket(a,tmp.b,tmp.cnt+1));
            //Fill b
            if(tmp.b!=b)    q.offer(new Bucket(tmp.a,b,tmp.cnt+1));

            //Empty a
            if(tmp.a!=0)    q.offer(new Bucket(0,tmp.b,tmp.cnt+1));
            //Empty b
            if(tmp.b!=0)    q.offer(new Bucket(tmp.a,0,tmp.cnt+1));

            //a -> b
            if(tmp.a!=0 && tmp.b!=b){
                if(tmp.a+tmp.b>=b)  q.offer(new Bucket(tmp.a-(b-tmp.b),b,tmp.cnt+1));
                else q.offer(new Bucket(0,tmp.a+tmp.b,tmp.cnt+1));
            }

            //b -> a
            if(tmp.b!=0 && tmp.a!=a){
                if(tmp.b+tmp.a>=a)  q.offer(new Bucket(a,tmp.b-(a-tmp.a),tmp.cnt+1));
                else q.offer(new Bucket(tmp.b+tmp.a,0,tmp.cnt+1));
            }




        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
