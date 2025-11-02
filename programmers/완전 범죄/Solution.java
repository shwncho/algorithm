import java.util.*;
class Solution {
    static int answer = 0;
    private void DFS(int s, int[][] info, int n, int m, int sumA, int sumB,Set<String> visited) {
        if(sumA >= n || sumB >= m)  return;

        String key = s+","+sumA+","+sumB;
        if(visited.contains(key))    return;

        if(s==info.length && sumA < n && sumB < m){
            answer = Math.min(answer, sumA);
            return;
        }

        DFS(s+1,info,n,m,sumA + info[s][0],sumB,visited);
        DFS(s+1,info,n,m,sumA, sumB+info[s][1],visited);

        visited.add(key);
    }
    public int solution(int[][] info, int n, int m) {
        answer = n;

        Set<String> visited = new HashSet<>();

        DFS(0,info,n,m,0,0,visited);



        return answer == n ? -1 : answer;
    }
}