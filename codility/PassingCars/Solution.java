// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int answer = 0;

        int countOne = 0;

        for(int i=A.length-1; i>=0; i--){

            if(A[i]==1) countOne++;
            else{
                answer+=countOne;
                if(answer>1000000000)   return -1;
            }
        }

        return answer;
    }
}