import java.util.*;
class Solution {
    static int[] map;
    static int cnt = 0;
    public int solution(int n) {
        int answer = 0;

        for(int i=0; i<n; i++){
            map = new int[n];
            map[0]=i;
            DFS(0,n);
        }
        answer = cnt;
        return answer;
    }

    private void DFS(int depth, int n){
        if(depth==n-1){
            cnt++;
            return;
        }

        for(int i=0; i<n; i++){
            map[depth+1]=i;
            if(isPossible(depth+1)) DFS(depth+1, n);
        }



    }

    private boolean isPossible(int depth){
        for(int i=0; i<depth; i++){
            if(map[i]==map[depth])   return false;
            if(Math.abs(depth-i) == Math.abs(map[depth]-map[i]))    return false;
        }

        return true;

    }
}