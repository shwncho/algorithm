import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<ArrayList<Integer>> lines, stations;
    static boolean[] visitedLine, visitedStation;

    static class Node implements Comparable<Node>{
        public int line,station,cnt;
        Node(int line, int station, int cnt){
            this.line = line;
            this.station = station;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        lines = new ArrayList<>();
        stations = new ArrayList<>();
        visitedLine = new boolean[M+1];
        visitedStation = new boolean[N+1];


        for(int i=0; i<=M; i++) lines.add(new ArrayList<>());
        for(int i=0; i<=N; i++) stations.add(new ArrayList<>());

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                int n = Integer.parseInt(st.nextToken());

                lines.get(i).add(n);
                stations.get(n).add(i);

            }
        }
        if(N==1) System.out.println(1);
        else System.out.println(BFS(1,N));
    }

    private static int BFS(int start, int end){

        Queue<Node> pQ = new PriorityQueue<>();
        visitedStation[start]=true;
        for(int line : stations.get(start)){
            visitedLine[line]=true;
            pQ.offer(new Node(line,start,1));
        }


        while(!pQ.isEmpty()){
            Node now = pQ.poll();

            if(now.station == end){
                return now.cnt+1;
            }

            for(int station : lines.get(now.line)){
                if(!visitedStation[station]){
                    visitedStation[station] = true;
                    pQ.offer(new Node(now.line, station, now.cnt));

                    for(int line : stations.get(station)){
                        if(!visitedLine[line]){
                            visitedLine[line]=true;
                            pQ.offer(new Node(line, station, now.cnt+1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
