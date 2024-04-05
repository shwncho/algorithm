import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] firstLightOn = new int[N];
        int[] firstLightOff = new int[N];
        int[] expected = new int[N];


        String s = br.readLine();
        for(int i=0; i<N; i++){
            int value = s.charAt(i) - '0';
            firstLightOn[i] = value;
            firstLightOff[i] = value;
        }

        s = br.readLine();
        for(int i=0; i<N; i++){
            int value = s.charAt(i)-'0';
            expected[i]=value;
        }

        firstLightOn[0] = 1 - firstLightOn[0];
        firstLightOn[1] = 1 - firstLightOn[1];

        int onCnt=1;
        int offCnt=0;
        for(int i=1; i<N; i++){

            //첫번째 스위치를 누른 배열
            if(firstLightOn[i-1] != expected[i-1]){
                firstLightOn[i-1] = 1 - firstLightOn[i-1];
                firstLightOn[i] = 1 - firstLightOn[i];
                if(i!=N-1)  firstLightOn[i+1] = 1 - firstLightOn[i+1];

                onCnt++;
            }

            //첫번째 스위치를 누르지 않은 배열
            if(firstLightOff[i-1] != expected[i-1]){
                firstLightOff[i-1] = 1 - firstLightOff[i-1];
                firstLightOff[i] = 1 - firstLightOff[i];
                if(i!=N-1)  firstLightOff[i+1] = 1 - firstLightOff[i+1];

                offCnt++;
            }
        }

        if(firstLightOn[N-1] != expected[N-1])  onCnt = Integer.MAX_VALUE;
        if(firstLightOff[N-1] != expected[N-1]) offCnt = Integer.MAX_VALUE;


        if(onCnt==Integer.MAX_VALUE && offCnt==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(Math.min(onCnt,offCnt));
        }
    }
}
