// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // Implement your solution here

        int answer = 0;
        int K = 0;
        while(N>=Math.pow(2,K)){
            if(N%Math.pow(2,K)==0)  answer = K;
            K++;
        }


        return answer;
    }
}