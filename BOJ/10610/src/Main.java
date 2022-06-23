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
        String[] s = br.readLine().split("");
        Integer[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int tmp=0;
        boolean zeroCheck = false;


        for(int i=0; i<s.length; i++){
            if(arr[i]==0)   zeroCheck=true;
            tmp+=arr[i];
        }

        if(!zeroCheck) System.out.println(-1);
        else if(tmp%3!=0) System.out.println(-1);
        else{
            Arrays.sort(arr, Collections.reverseOrder());
            for (Integer integer : arr) {
                System.out.print(integer);
            }
        }




    }
}
