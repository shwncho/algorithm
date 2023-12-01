import java.io.*;
import java.util.*;
public class Main {
    static int[] arr = new int[9];
    static int[] combi = new int[7];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        combi(0,0);
    }
    public static void combi(int L, int s){
        if(L==7){
            int sum = 0;
            for(int i=0; i<7; i++){
                sum+=combi[i];
            }

            if(sum==100){
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<7; i++){
                    sb.append(combi[i]).append("\n");
                }
                System.out.println(sb.toString());
                System.exit(0);
            }
        }
        else{
            for(int i=s; i<9; i++){
                combi[L]=arr[i];
                combi(L+1,i+1);
            }
        }
    }
}
