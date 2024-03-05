import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<N; i++){
            int value = arr[i];

            if(answer.get(answer.size()-1) < value){
                answer.add(value);
            }
            else{
                int left = 0;
                int right = answer.size()-1;

                while(left < right){
                    int mid = (left + right) / 2;

                    if(answer.get(mid) <= value) left = mid + 1;
                    else right = mid;
                }
                answer.set(right, value);
            }
        }

        System.out.println(answer.size());

    }
}
