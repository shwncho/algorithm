// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        Map<Integer,Integer> result = new HashMap<>();

        for(int i=0; i<A.length; i++){
            result.put(A[i],result.getOrDefault(A[i],0)+1);
        }

        for(int i=0; i<A.length; i++){
            if(result.get(A[i])==1) return A[i];
        }

        return -1;
    }
}