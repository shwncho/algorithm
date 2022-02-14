import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] solution(int n, int[][]arr){
        Arrays.sort(arr,(e1,e2) -> {
            if(e1[0]==e2[0]){
                return e1[1]-e2[1];
            } else{
                return e1[0]-e2[0];
            }

        });
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] arr =new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        int[][] result =solution(n,arr);
        for(int i=0; i<n; i++){
            System.out.println(result[i][0]+" "+result[i][1]);
        }
    }
}
