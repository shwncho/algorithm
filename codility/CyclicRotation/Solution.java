// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        int len = A.length;
        if(len == 0)   return new int[]{};

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<len; i++){
            dq.offerLast(A[i]);
        }

        while(K-->0){
            dq.offerFirst(dq.pollLast());
        }

        return dq.stream().mapToInt(Integer::intValue).toArray();
    }
}
