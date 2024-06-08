import java.util.*;
import java.io.*;
public class Main {
    static List<List<Integer>> lines = new ArrayList<>();
    static Map<Integer, List<Integer>> stations = new HashMap<>();
    static boolean[] vLines,vStations;
    static int dest;
    static class Node{
        int stationNumber, cnt;
        Node(int stationNumber, int cnt){
            this.stationNumber = stationNumber;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++){
            lines.add(new ArrayList<>());
        }
        int k;
        int sMax = 0;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                int s = Integer.parseInt(st.nextToken());
                sMax = Math.max(sMax, s);
                stations.put(s,new ArrayList<>());
                lines.get(i).add(s);
            }
        }

        vLines = new boolean[N+1];
        vStations = new boolean[sMax+1];

        for(int i=1; i<=N; i++){
            for(int l : lines.get(i)){
                stations.get(l).add(i);
            }
        }

        dest = Integer.parseInt(br.readLine());
        if(dest==0){
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(BFS());


    }

    private static int BFS(){
        Queue<Node> q = new LinkedList<>();
        vStations[0]=true;
        q.offer(new Node(0,0));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int l : stations.get(tmp.stationNumber)){
                if(!vLines[l]){
                    vLines[l]=true;
                    int nextCnt = tmp.cnt + 1;
                    for(int s : lines.get(l)){
                        if(s==dest) return nextCnt - 1;
                        if(!vStations[s]){
                            vStations[s]=true;
                            q.offer(new Node(s,nextCnt));
                        }
                    }
                }
            }
        }


        return -1;
    }
}
