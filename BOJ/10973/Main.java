import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] arr;
    public static boolean prevPermutation(){
        int i = arr.length-1;

        while(i>0 && arr[i-1] < arr[i]) i--;

        //i==0 이면 이전 순열 못구함
        if(i==0)    return false;

        int j =arr.length-1;
        while(arr[i-1]<arr[j])  j--;

        swap(arr, i-1, j);

        //i-1번째를 다음 수로 올려주고, 기존 내림차순들도 다음 수로 만들기 위해 처음과
        int k = arr.length-1;
        while( i< k){
            swap(arr,i++,k--);
        }

        return true;

    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr=new int[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        if(prevPermutation()){
            for(int x : arr){
                System.out.print(x+" ");
            }
        }
        else System.out.println(-1);

    }

}