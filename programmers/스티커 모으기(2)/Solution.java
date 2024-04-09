import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;

        if(n==1)    return sticker[0];

        int[][] dp = new int[n][2];

        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                dp[i][j]=sticker[i];
            }
        }
        //0번째 인덱스를 뽑는 경우
        dp[n-1][0]=0;
        for(int i=1; i<n; i++){
            if(i==1) dp[i][0]=dp[i-1][0];
            else dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0]+dp[i][0]);
        }

        //0번째 인덱스를 안뽑는 경우
        dp[0][1]=0;
        for(int i=2; i<n; i++){
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][1]+dp[i][1]);
        }

        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}