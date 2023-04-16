import java.util.*;
import java.io.*;
public class Main {
    static int[] arr,answer;
    public static void binarySearch(int left, int right, int key){
        int l = left;
        int r = right;

        while(l < r){
            int mid = (l+r)/2;

            if(answer[mid] < key){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        answer[l]=key;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        answer = new int[n];

        arr= new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        answer[0]=arr[0];
        int len=1;
        for(int i=1; i<n; i++){
            int key = arr[i];

            if(answer[len-1] < key){
                answer[len++]=key;
            }
            else{
                binarySearch(0, len,key);
            }
        }

        System.out.println(len);
    }
}
