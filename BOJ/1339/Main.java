import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        String[] arr =new String[n];
        int[] alpha = new int[26];

        for(int i=0; i<n; i++){
            arr[i]=br.readLine();
        }

        for(int i=0; i<n; i++){
            int tmp =(int)(Math.pow(10,arr[i].length()-1));
            for(int j=0; j<arr[i].length(); j++){
                alpha[(int)arr[i].charAt(j)-65]+=tmp;
                tmp/=10;
            }
        }

        int num=9;
        int answer=0;
        Arrays.sort(alpha);
        for(int i=alpha.length-1; i>=0; i--){
            if(alpha[i]==0) break;

            answer+=num*alpha[i];
            num--;
        }

        System.out.println(answer);


    }
}
