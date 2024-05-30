import java.util.*;
class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int n = arr.length;
        boolean[] checked = new boolean[n+1];
        for(int i=0; i<n; i++){
            //범위를 넘어선 값이 있을 경우
            if(arr[i]<=0 || arr[i]>n)   return false;
            //똑같은 값이 있을 경우
            if(checked[arr[i]]) return false;

            checked[arr[i]]=true;
        }

        for(int i=1; i<=n; i++){
            if(!checked[i]) return false;
        }


        return answer;
    }
}