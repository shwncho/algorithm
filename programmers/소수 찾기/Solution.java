import java.util.*;
class Solution {
    static String[] pm;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void DFS(int L, int n, String[] arr){
        if(L==n){

            if(pm[0].equals("0"))    return;
            String s="";
            for(String x : pm)  s+=x;
            int tmp = Integer.parseInt(s);
            if(tmp==1)  return;
            else{
                if(!list.contains(tmp)) list.add(tmp);
            }

        }
        else{
            for(int i=0; i<arr.length; i++){
                if(!visited[i]){
                    visited[i]=true;
                    pm[L]=arr[i];
                    DFS(L+1,n,arr);
                    visited[i]=false;
                }
            }
        }

    }
    public int solution(String numbers) {
        int answer=0;
        String[] arr = new String[numbers.length()];

        for(int i=0; i<numbers.length(); i++){
            arr[i]=numbers.substring(i,i+1);
        }

        for(int i=1; i<=numbers.length(); i++){
            pm=new String[i];
            visited=new boolean[numbers.length()];
            DFS(0,i,arr);
        }

        for(int x : list){
            boolean flag=true;
            for(int i=2; i<x; i++){
                if(x%i==0){
                    flag=false;
                    break;
                }
            }
            if(flag)    answer++;
        }
        return answer;
    }
}