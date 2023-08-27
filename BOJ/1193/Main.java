import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 대각선 칸의 개수
// 홀수 짝수에 따라 위,아래 방향 어디서 출발하는지
// 분모,분자 값 설정 어떻게 하는지
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        //대각선 칸 개수
        int crossCnt=1;
        //누적된 칸 개수
        int prevCnt=0;

        while(true){
            if(x <= crossCnt + prevCnt){
                if(crossCnt%2==1){
                    System.out.println((crossCnt - (x - prevCnt -1)) + "/" + (x-prevCnt));
                    break;
                }
                else{
                    System.out.println((x-prevCnt) + "/" + (crossCnt - (x - prevCnt -1)));
                    break;
                }
            }
            else{
                prevCnt+=crossCnt;
                crossCnt++;
            }
        }

    }
}
