// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int Y, int D) {
        int answer = 0;

        Y-=X;
        if(Y%D==0)  answer=Y/D;
        else    answer=Y/D + 1;

        return answer;
    }
}