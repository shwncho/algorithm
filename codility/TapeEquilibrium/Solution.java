// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int answer = Integer.MAX_VALUE;

        int leftSum = 0;
        int rightSum = 0;
        for(int i=0; i<A.length; i++)   rightSum+=A[i];

        for(int i=0; i<A.length-1; i++){
            leftSum+=A[i];
            rightSum-=A[i];

            answer = Math.min(answer, Math.abs(leftSum-rightSum));
        }


        return answer;
    }
}