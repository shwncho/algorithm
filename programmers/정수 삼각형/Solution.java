import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];
        int n = triangle.length;

        for(int i=1; i<n; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0)    triangle[i][j] +=triangle[i-1][j];
                else if(j==triangle[i].length-1)    triangle[i][j]+=triangle[i-1][j-1];
                else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
            }
        }

        for(int i=0; i<n; i++){
            answer = Math.max(answer, triangle[n-1][i]);
        }
        return answer;
    }
}