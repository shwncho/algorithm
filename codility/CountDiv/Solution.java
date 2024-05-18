// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
        if(A%K==0)  return B/K - A/K + 1;
        return B/K - A/K;
    }
}