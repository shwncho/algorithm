import java.util.*;
class Solution {
    private int answer = 0;
    private void DFS(int L, int s, int[] arr, int[][] q, int[] ans, int n) {
        if(L==5) {
            boolean flag = true;
            Set<Integer> set = new HashSet<>();
            for(int tmp : arr)  set.add(tmp);
            for(int m = 0; m < ans.length; m++) {
                int cnt = 0;
                for(int k=0; k<5; k++) {
                    if(set.contains(q[m][k]))   cnt++;
                }

                if(ans[m] != cnt) {
                    flag = false;
                    break;
                }
            }

            if(flag)    answer++;

            return;
        }

        for(int i=s; i<=n; i++) {
            arr[L] = i;
            DFS(L+1, i+1,arr,q,ans,n);
        }
    }
    public int solution(int n, int[][] q, int[] ans) {
        int[] arr = new int[n];
        DFS(0,1,arr,q,ans,n);
        return answer;
    }
}