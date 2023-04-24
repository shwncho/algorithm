import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int change = 1000 - money;
        int[] arr = {500,100,50,10,5,1};
        int answer = 0;

        for(int i=0; i<6; i++){
            answer+=change/arr[i];
            change=change%arr[i];
        }


        System.out.println(answer);
    }
}
