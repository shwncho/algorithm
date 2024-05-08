// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // Implement your solution here
        int answer = 1;
        int std = 0;

        if(A.length<=1) return A.length;


        for(int i=1; i<A.length; i++){
            if(B[std]<A[i]){
                answer++;
                std=i;
            }
        }


        return answer;
    }
}