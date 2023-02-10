import java.util.*;
import java.io.*;

public class Solution {
    static int answer=0;
    static int[] combi;
    public int solution(int[] nums) {
        combi=new int[3];
        DFS(0,0,nums);

        return answer;
    }

    public static void DFS(int L, int s, int[] arr){
        if(L==3){
            int sum=0;
            boolean flag=true;
            for(int x : combi){
                sum+=x;
            }

            for(int i=2; i<sum; i++){
                if(sum%i==0){
                    flag=false;
                    break;
                }
            }

            if(flag)    answer++;
        }
        else{
            for(int i=s; i<arr.length; i++){
                combi[L]=arr[i];
                DFS(L+1,i+1,arr);
            }
        }
    }
}
