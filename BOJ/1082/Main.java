import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  P[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        //숫자의 최대 길이 100자리
        int[] answer = new int[100];
        //현재 비용
        int cost = 0;
        //현재 인덱스
        int idx = 0;

        //가장 싼 숫자찾기
        int minIdx=findMin(0,P);
        // 0이 가장 쌀 경우
        if(minIdx==0){
            minIdx = findMin(1,P);
            //두번째로 싼 숫자 살 수 있는 경우
            if(P[minIdx]<=M){
                answer[idx++]=minIdx;
                cost+=P[minIdx];
                minIdx=0;
            }
            else{
                System.out.println(0);
                return;
            }
        }

        //가장 싼 숫자로 채우기
        while(cost+P[minIdx]<=M){
            answer[idx++]=minIdx;
            cost+=P[minIdx];
        }

        //가장 싼 숫자로 길게 채워진 상황에서 큰 숫자로 교체하기
        for(int i=0; i<idx; i++){
            for(int j=N-1; j>=0; j--){
                if(cost-P[answer[i]]+P[j]<=M){
                    cost+=P[j]-P[answer[i]];
                    answer[i]=j;
                    break;
                }
            }
        }

        for(int i=0; i<idx; i++){
            System.out.print(answer[i]);
        }


    }

    public static int findMin(int s, int[] P){
        int idx=0;
        //비용의 최대 값은 50
        int min = 51;
        for(int i=s; i<P.length; i++){
            if(min > P[i]){
                min = P[i];
                idx = i;
            }
        }
        return idx;
    }

}
