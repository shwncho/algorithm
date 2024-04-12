import java.util.*;
class Solution {
    static int[] unf;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        unf = new int[n];
        for(int i=0; i<n; i++)  unf[i] = i;

        Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);

        for(int[] c : costs){
            if(find(c[0])!=find(c[1])){
                answer+=c[2];
                union(c[0],c[1]);
            }
        }

        return answer;
    }
    private int find(int v){
        if(v==unf[v])   return v;
        else return unf[v] = find(unf[v]);
    }

    private void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb)  unf[fa]=fb;
    }
}