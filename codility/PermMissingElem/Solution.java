// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int answer =0;

        boolean[] checked = new boolean[100002];
        for(int i=0; i<A.length; i++)   checked[A[i]]= true;

        for(int i=1; i<=100001; i++){
            if(!checked[i]){
                answer=i;
                break;
            }
        }
        return answer;
    }
}