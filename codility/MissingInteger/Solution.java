// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++) set.add(A[i]);

        for(int i=1; i<=1000000; i++){
            if(!set.contains(i))    return i;
        }

        return -1;
    }
}