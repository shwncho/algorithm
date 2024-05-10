// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] answer = new int[N];

        int currentMax = 0;
        int lastMax = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]==N+1){
                lastMax = currentMax;
            }
            else{
                if(answer[A[i]-1]<lastMax){
                    answer[A[i]-1] = lastMax + 1;
                }
                else    answer[A[i]-1]++;

                currentMax = Math.max(currentMax, answer[A[i]-1]);
            }
        }

        for(int i=0; i<N; i++){
            if(answer[i] < lastMax){
                answer[i] = lastMax;
            }
        }


        return answer;
    }
}
