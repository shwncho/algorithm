import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] answer = new int[n];
        int[] index = new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  arr[i] = Integer.parseInt(st.nextToken());

        int len=1;
        answer[0]=arr[0];
        for(int i=1; i<n; i++){
            int key = arr[i];

            if(answer[len-1]<key){
                answer[len++]=key;
                index[i]=len-1;
            }
            else{
                int left =0;
                int right = len-1;
                while(left < right){
                    int mid = (left+right)/2;
                    if(answer[mid] < key){
                        left=mid+1;
                    }
                    else    right=mid;
                }
                answer[left]=key;
                index[i]=left;
            }
        }
        System.out.println(len);
        Stack<Integer> stk = new Stack<>();

        // 가장 긴 수열의 길이 -1 => 가장 긴 수열의 마지막 인덱스
        int idx = len-1;

        for(int i=n-1; i>=0; i--){
            if(idx == index[i]){
                stk.push(arr[i]);
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop()+" ");
        }

        System.out.println(sb);

    }
}
