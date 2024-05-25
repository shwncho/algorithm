import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  arr[i] = Integer.parseInt(st.nextToken());



        System.out.println(mergeSort(0,N-1));
    }

    private static long mergeSort(int start, int end){
        if(start>=end)  return 0;

        long inversions = 0;
        int mid = (start + end) / 2;


        inversions += mergeSort(start, mid);
        inversions += mergeSort(mid+1, end);
        inversions += mergeCountInversion(start, mid, end);

        return inversions;

    }

    private static long mergeCountInversion(int start, int mid, int end){
        long inversions = 0;
        int p1 = start, p2=mid+1, idx=start;
        while(p1<=mid && p2<=end){
            if(arr[p1]<=arr[p2]){
                tmp[idx++] = arr[p1++];
            }
            else{
                inversions += (mid - p1 + 1);
                tmp[idx++] = arr[p2++];
            }
        }


        while(p1<=mid)  tmp[idx++] = arr[p1++];
        while(p2<=end) tmp[idx++] = arr[p2++];

        for(int i=start; i<=end; i++){
            arr[i] = tmp[i];
        }

        return inversions;
    }
}
