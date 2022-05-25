import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int sum = 0;
        String[] subtraction = br.readLine().split("-");

        for(int i=0; i<subtraction.length; i++){
            int tmp=0;

            String[] addition = subtraction[i].split("\\+");

            for(int j=0; j<addition.length; j++){
                tmp +=Integer.parseInt(addition[j]);
            }

            if(i==0)    sum=tmp;
            else    sum-=tmp;
        }
        System.out.println(sum);
        br.close();

    }
}
