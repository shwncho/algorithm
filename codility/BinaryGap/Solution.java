// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        int answer = 0;

        String binary = Integer.toBinaryString(N);

        int left=0,right=0;
        while(left<=right && right<binary.length()){
            if(binary.charAt(right)=='1'){
                answer=Math.max(answer,right-left-1);
                left=right;
            }
            right++;

        }

        return answer;
    }
}