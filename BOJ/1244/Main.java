import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        while(k-->0){
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex==1){
                for(int i = num; i<=N; i+=num){
                    if(arr[i]==0)   arr[i]=1;
                    else arr[i]=0;
                }
            }
            else{
                int left = num-1;
                int right = num+1;

                while(true){
                    if(left<1 || right>N)   break;

                    if(arr[left] == arr[right]){
                        left--;
                        right++;
                    }
                    else break;
                }

                left++;
                right--;

                if(left!=num && right!=num){
                    for(int i=left; i<num; i++){
                        if(arr[i]==0)   arr[i]=1;
                        else arr[i]=0;
                    }

                    for(int i=num+1; i<=right; i++){
                        if(arr[i]==0)   arr[i]=1;
                        else    arr[i]=0;
                    }
                }


                if(arr[num]==0) arr[num]=1;
                else arr[num]=0;


            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(arr[i]+" ");
            if(i%20==0) sb.append("\n");
        }
        System.out.println(sb);
    }
}
