import java.io.*;
import java.util.*;

class Main{
    static int n;
    static boolean[][] palindrome;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = str.length();
        palindrome=new boolean[n+1][n+1];
        int[] dp = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        checkPalindrome(str,n);

        dp[0]=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(palindrome[j][i])    dp[i]=Math.min(dp[i],dp[j-1]+1);
            }
        }

        System.out.println(dp[n]);
    }

    public static void checkPalindrome(String str, int len){

        for(int start=1; start<=len; start++){
            for(int end=start; end<=len; end++){
                boolean flag = true;

                //증가 or 감소했을 때 index 범위를 벗어나면 안되므로 -1
                int s = start-1;
                int e = end-1;

                while(s<=e){
                    if(str.charAt(s++)!=str.charAt(e--)){
                        flag=false;
                        break;
                    }
                }

                if(flag)    palindrome[start][end]=true;
            }
        }
    }
}