import java.util.*;
import java.io.*;
public class Main {
    static int[] arr = new int[100001];
    static final int TMP = 10_000_000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<=100000; i++){
            arr[i] = TMP;
        }

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int problemNumber = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            arr[problemNumber] = level;
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            if(str.equals("add")){
                int newProblemNumber = Integer.parseInt(st.nextToken());
                int newLevel = Integer.parseInt(st.nextToken());
                arr[newProblemNumber] = newLevel;
            }
            else if(str.equals("recommend")){
                String x = st.nextToken();
                int idx = 0;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                if(x.equals("1")){
                    for(int i=1; i<100001; i++){
                        if(arr[i]!=TMP && max<arr[i]){
                            idx = i;
                            max = arr[i];
                        }
                        else if(arr[i]!=TMP  && max==arr[i]){
                            if(i>idx){
                                idx = i;
                            }
                        }
                    }
                }
                else if(x.equals("-1")){
                    for(int i=1; i<100001; i++){
                        if(arr[i]!=TMP && min>arr[i]){
                            idx = i;
                            min = arr[i];
                        }
                        else if(arr[i]!=TMP && min==arr[i]){
                            if(i<idx){
                                idx = i;
                            }
                        }
                    }
                }

                sb.append(idx).append("\n");

            }
            //solved
            else{
                int newProblemNumber = Integer.parseInt(st.nextToken());
                arr[newProblemNumber]=TMP;
            }



        }

        System.out.println(sb);
    }
}
