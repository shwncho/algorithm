import java.util.*;
class Solution {
    static int max = Integer.MIN_VALUE;
    static int[] checked;
    static int[] pm;
    public static void permutation(int L, int n, int m, int[][] ability){
        if(L==m){
            int sum = 0;
            int idx=0;
            for(int value : pm){
                sum+=ability[value][idx++];
            }
            max = Math.max(max, sum);
        }
        else{
            for(int i=0; i<n; i++){
                if(checked[i]==0){
                    checked[i]=1;
                    pm[L]=i;
                    permutation(L+1,n,m,ability);
                    checked[i]=0;
                }
            }
        }
    }
    public int solution(int[][] ability) {
        int answer = 0;
        checked = new int[ability.length];
        pm = new int[ability[0].length];
        permutation(0,ability.length, ability[0].length,ability);

        answer = max;
        return answer;
    }
}