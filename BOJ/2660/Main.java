import java.io.*;
import java.util.*;
class Person implements Comparable<Person>{
    public int score,num;
    Person(int score, int num){
        this.score= score;
        this.num = num;
    }

    @Override
    public int compareTo(Person p){
        return this.score - p.score;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int INF = 10_000_000;
        int[][] graph = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                graph[i][j] = i==j ? 0 : INF;
            }
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1)  break;

            graph[a][b]=1;
            graph[b][a]=1;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }


        Queue<Person> pQ = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            int max = 0;
            for(int j=1; j<=N; j++){
                max=Math.max(max,graph[i][j]);
            }
            pQ.offer(new Person(max, i));
        }

        List<Integer> list = new ArrayList<>();
        int min = pQ.peek().score;
        while(!pQ.isEmpty() && min == pQ.peek().score){
            list.add(pQ.poll().num);
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(list.size()).append("\n");
        for(int x : list){
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
