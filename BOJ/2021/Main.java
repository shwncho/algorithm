import java.util.*;
import java.io.*;
public class Main {

    static class Node implements  Comparable<Node>{
        public int line, station, cnt;
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
    static ArrayList<ArrayList<Integer>> line, station;
    static boolean[] visitedLine, visitedStation;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        line = new ArrayList<>();
        for(int i=0; i<=L; i++) line.add(new ArrayList<>());
        station = new ArrayList<>();
        for(int i=0; i<=N; i++) station.add(new ArrayList<>());

        visitedLine = new boolean[L+1];
        visitedStation = new boolean[N+1];

        for(int i=1; i<=L; i++){
            st = new StringTokenizer(br.readLine());

            while(true){
                int value = Integer.parseInt(st.nextToken());
                if(value==-1)   break;

                line.get(i).add(value);
                station.get(value).add(i);
            }

        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        if(start==end) System.out.println(0);
        else System.out.println(BFS(start,end));


    }

    private static int BFS(int start, int end){
        Queue<Node> pQ = new PriorityQueue<>();
        visitedStation[start]=true;
        for(int line : station.get(start)){
            visitedLine[line]=true;
            pQ.offer(new Node(line,start,0));
        }
        while(!pQ.isEmpty()){
            Node tmp = pQ.poll();

            if(tmp.station == end){
                return tmp.cnt;
            }

            for(int nowStation : line.get(tmp.line)){
                if(!visitedStation[nowStation]){
                    visitedStation[nowStation]=true;
                    pQ.offer(new Node(tmp.line,nowStation, tmp.cnt));

                    for(int nowLine : station.get(nowStation)){
                        if(!visitedLine[nowLine]){
                            visitedLine[nowLine]=true;
                            pQ.offer(new Node(nowLine, nowStation, tmp.cnt+1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
