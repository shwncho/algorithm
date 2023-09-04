import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;

        String word = "";
        while(n>0){
            word = String.valueOf(n%k) + word;
            n=n/k;
        }
        String[] str = word.split("0");

        int cnt = 0;
        for(String tmp : str){
            if(tmp.isEmpty())   continue;
            if(isPrime(Long.parseLong(tmp)))   cnt++;
        }

        answer = cnt;
        return answer;
    }

    public static boolean isPrime(long num){
        if(num==1)  return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0)    return false;
        }

        return true;
    }
}