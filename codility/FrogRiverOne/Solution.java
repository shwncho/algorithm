// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        Set<Integer> s = new HashSet<>();
        for(int i=1; i<=X; i++) s.add(i);

        for(int i=0; i<A.length; i++){
            if(s.contains(A[i]))    s.remove(A[i]);

            if(s.size()==0) return i;
        }
        return -1;
    }
}