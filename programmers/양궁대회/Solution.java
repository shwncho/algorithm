import java.util.*;
class Solution {
    public static int[] pm;
    public static int max = Integer.MIN_VALUE;
    public static int[] result = new int[11];
    public static boolean flag=true;
    public int[] solution(int n, int[] info) {
        int[] answer;
        pm = new int[n];
        permutation(0,0,n,info);

        if(flag){
            answer = new int[1];
            answer[0]=-1;
        }
        else{
            answer=result.clone();
        }

        return answer;
    }

    public static void permutation(int L,int s,int n, int[] info){
        if(L==n){
            int[] lionArrow = new int[11];
            for(int i=0; i<n; i++){
                int score = 10-pm[i];
                lionArrow[pm[i]]++;
            }

            int apeachScore = 0;
            int ryanScore = 0;

            for(int i=0; i<11; i++){
                if(info[i]==0 && lionArrow[i]==0)   continue;
                if(info[i]>=lionArrow[i])   apeachScore+=10-i;
                else    ryanScore+=10-i;
            }

            if(apeachScore<ryanScore){
                flag=false;
                if(max == ryanScore - apeachScore){
                    for(int j=10; j>=0; j--){
                        if(lionArrow[j] > result[j]){
                            result = lionArrow.clone();
                            break;
                        }
                        else if(lionArrow[j] < result[j])   break;
                    }
                }
                if(max < (ryanScore - apeachScore)){
                    max = ryanScore - apeachScore;
                    result = lionArrow.clone();
                }

            }
        }
        else{
            for(int i=s; i<11; i++){
                pm[L]=i;
                permutation(L+1,i,n,info);
            }
        }
    }
}