import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * "배수판정법"을 아는 것이 중요
 * 30은 3과 10의 배수이므로 3의 배수판정법 + 10의 배수판정법 이용
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer[] arr = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int sum=0;


        for(int i=0; i<s.length(); i++){
            sum+=arr[i];
        }

        if(!s.contains("0")) System.out.println(-1);
        else if(sum%3!=0) System.out.println(-1);
        else{
            Arrays.sort(arr, Collections.reverseOrder());
            for (Integer integer : arr) {
                System.out.print(integer);
            }
        }




    }
}
