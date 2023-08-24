import java.util.*;

class Solution {
    static int maxAlp;
    static int maxCop;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        maxAlp = Integer.MIN_VALUE;
        maxCop = Integer.MIN_VALUE;

        for(int i=0; i<problems.length; i++){
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }

        alp = Math.min(alp,maxAlp);
        cop = Math.min(cop,maxCop);

        int[][] dp = new int[maxAlp+1][maxCop+1];


        for(int i=alp; i<=maxAlp; i++){
            for(int j=cop; j<=maxCop; j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        dp[alp][cop]=0;



        for(int i=alp; i<=maxAlp; i++){
            for(int j=cop; j<=maxCop; j++){
                if(i < maxAlp){
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                }
                if(j < maxCop){
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }


                for(int k=0; k<problems.length; k++){

                    if(i>=problems[k][0] && j>=problems[k][1]){
                        //최대 알고력 or 코딩력을 넘어서지만, cost가 적은 경우도 고려
                        int nx = Math.min(maxAlp, i + problems[k][2]);
                        int ny = Math.min(maxCop, j + problems[k][3]);

                        dp[nx][ny]=Math.min(dp[nx][ny], dp[i][j]+problems[k][4]);

                    }
                }
            }
        }



        answer = dp[maxAlp][maxCop];
        return answer;
    }

}