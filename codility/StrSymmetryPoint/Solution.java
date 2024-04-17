// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // Implement your solution here
        if(S.length()==0)   return -1;
        if(S.length()==1)   return 0;
        if(S.length()%2==0) return -1;


        int mid = S.length() / 2;
        String left = S.substring(0,mid);
        String right = S.substring(mid+1, S.length());

        StringBuilder sb = new StringBuilder(right);

        if(left.equals(sb.reverse().toString()))  return mid;
        return -1;
    }
}