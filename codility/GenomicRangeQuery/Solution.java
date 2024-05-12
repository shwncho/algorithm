// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int[] answer = new int[P.length];

        int[] A = new int[S.length()+1];
        int[] C = new int[S.length()+1];
        int[] G = new int[S.length()+1];
        int[] T = new int[S.length()+1];

        //P[i] ~ Q[i]의 구간에서 특정 문자가 나타났는지 변화값을 알기위해 i+1번째에 변화를 기록
        for(int i=0; i<S.length(); i++){
            switch(S.charAt(i)){
                case 'A':
                    A[i+1]++;
                    break;
                case 'C':
                    C[i+1]++;
                    break;
                case 'G':
                    G[i+1]++;
                    break;
                default:
                    T[i+1]++;
                    break;
            }

            A[i+1]+=A[i];
            C[i+1]+=C[i];
            G[i+1]+=G[i];
            T[i+1]+=T[i];
        }

        for(int i=0; i<P.length; i++){
            if(A[Q[i]+1] - A[P[i]]>0)   answer[i]=1;
            else if(C[Q[i]+1] - C[P[i]]>0)  answer[i]=2;
            else if(G[Q[i]+1] - G[P[i]]>0)  answer[i]=3;
            else if(T[Q[i]+1] - T[P[i]]>0)  answer[i]=4;
        }
        return answer;
    }
}