import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++){
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<N; i++){
            boolean[] check = new boolean[M+1];
            for(int j=0; j<N; j++){
                if(i==j)    continue;

                for(int x : graph.get(j)){
                    check[x]=true;
                }

            }

            boolean result = true;
            for(int k=1; k<=M; k++){
                if(!check[k]){
                    result=false;
                    break;
                }
            }

            if(result){
                System.out.println(1);
                System.exit(0);
            }
        }

        System.out.println(0);


    }
}
