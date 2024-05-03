// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        int[] dp = new int[N];

        Arrays.fill(dp,Integer.MIN_VALUE);

        dp[0] = A[0];
        for(int i=1; i<A.length; i++){
            for(int j=1; j<=6; j++){
                if(i-j>=0){
                    dp[i]=Math.max(dp[i], dp[i-j]+A[i]);
                }
            }
        }
        return dp[N-1];
    }
}