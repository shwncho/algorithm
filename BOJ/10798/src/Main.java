import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        int max=0;
        for(int i=0; i<5; i++){
            arr[i]=br.readLine().toCharArray();
            if(arr[i].length>max)   max=arr[i].length;
        }

        for(int j=0; j<max; j++){
            for(int i=0; i<5; i++){
                if(arr[i].length<j+1)   continue;
                System.out.print(arr[i][j]);
            }
        }

    }
}
