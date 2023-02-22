import java.util.*;
class Dungeon{
    //a -> 최소 필요도, b -> 소모 피로도
    public int a,b;
    Dungeon(int a, int b){
        this.a=a;
        this.b=b;
    }

}
class Solution {
    static boolean[] visited;
    static Dungeon[] pm;
    static int answer=Integer.MIN_VALUE;
    public static void DFS(int L, int n, int k,Dungeon[] arr){
        if(L==n){
            int cnt=0;
            for(Dungeon d : pm){
                if(d.a<=k){
                    k-=d.b;
                    cnt++;
                }
            }
            answer=Math.max(answer,cnt);
        }
        else{
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    visited[i]=true;
                    pm[L]=arr[i];
                    DFS(L+1,n,k,arr);
                    visited[i]=false;
                }
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        Dungeon[] arr = new Dungeon[n];

        for(int i=0; i<dungeons.length; i++){
            arr[i]=new Dungeon(dungeons[i][0],dungeons[i][1]);
        }

        visited = new boolean[n];
        pm=new Dungeon[n];

        DFS(0,n,k,arr);




        return answer;
    }
}