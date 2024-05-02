// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<A.length; i++){
            if(s.contains(A[i]))    s.remove(A[i]);
            else    s.add(A[i]);
        }

        for(int value : s)  answer = value;

        return answer;
    }
}