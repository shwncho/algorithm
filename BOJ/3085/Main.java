import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];


        String s="";
        for(int i=0; i<n; i++){
            s=br.readLine();
            arr[i]=s.toCharArray();
        }

        //행 swap
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                char tmp = arr[i][j];
                arr[i][j]=arr[i][j+1];
                arr[i][j+1]=tmp;

                check(arr,n);

                tmp=arr[i][j];
                arr[i][j]=arr[i][j+1];
                arr[i][j+1]=tmp;

            }
        }

        //열 swap
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                char tmp = arr[j][i];
                arr[j][i]=arr[j+1][i];
                arr[j+1][i]=tmp;

                check(arr,n);

                tmp = arr[j][i];
                arr[j][i]=arr[j+1][i];
                arr[j+1][i]=tmp;
            }
        }

        System.out.println(answer);



    }

    public static void check(char[][] arr, int n){
        char c;
        for(int i=0; i<n; i++){
            int cnt=1;
            c=arr[i][0];
            for(int j=1; j<n; j++){
                if(arr[i][j]==c)    cnt++;
                else    cnt=1;

                if(cnt>answer)  answer=cnt;

                c=arr[i][j];
            }
        }

        for(int i=0; i<n; i++){
            int cnt=1;
            c=arr[0][i];
            for(int j=1; j<n; j++){
                if(arr[j][i]==c)    cnt++;
                else    cnt=1;

                if(cnt>answer)  answer=cnt;

                c=arr[j][i];
            }
        }
    }



}
