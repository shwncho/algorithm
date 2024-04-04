import java.util.*;
import java.io.*;
public class Main {

    static class Beaker{

        public int a,b,c;
        Beaker(int a, int b, int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Beaker> pQ = new LinkedList<>();
        Set<Integer> answer = new TreeSet<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[][][] visited = new boolean[a+1][b+1][c+1];
        pQ.offer(new Beaker(0,0,c));

        while(!pQ.isEmpty()) {

            Beaker tmp = pQ.poll();

            if(visited[tmp.a][tmp.b][tmp.c])    continue;

            visited[tmp.a][tmp.b][tmp.c]=true;

            if(tmp.a==0)    answer.add(tmp.c);

            // a->b
            // a가 b를 채워준다
            if(tmp.a + tmp.b >=b)   pQ.offer(new Beaker(tmp.a-(b-tmp.b),b,tmp.c));
            // a를 비운다
            else    pQ.offer(new Beaker(0,tmp.a+tmp.b,tmp.c));

            // a->c
            if(tmp.a + tmp.c >= c)  pQ.offer(new Beaker(tmp.a-(c-tmp.c),tmp.b,c));
            else pQ.offer(new Beaker(0, tmp.b, tmp.a+tmp.c));

            // b->a
            if(tmp.b + tmp.a >=a)   pQ.offer(new Beaker(a,tmp.b-(a-tmp.a),tmp.c));
            else pQ.offer(new Beaker(tmp.b+tmp.a,0,tmp.c));

            // b->c
            if(tmp.b + tmp.c >=c)   pQ.offer(new Beaker(tmp.a,tmp.b-(c-tmp.c),c));
            else pQ.offer(new Beaker(tmp.a,0,tmp.b+tmp.c));

            // c->a
            if(tmp.c + tmp.a >=a)   pQ.offer(new Beaker(a, tmp.b, tmp.c-(a-tmp.a)));
            else pQ.offer(new Beaker(tmp.c+tmp.a,tmp.b,0));

            // c->b
            if(tmp.c + tmp.b >= b)  pQ.offer(new Beaker(tmp.a,b, tmp.c-(b-tmp.b)));
            else pQ.offer(new Beaker(tmp.a,tmp.c+tmp.b,0));

        }

        StringBuilder sb = new StringBuilder();
        for(int x : answer) sb.append(x).append(" ");
        System.out.println(sb);


    }
}
