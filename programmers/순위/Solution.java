class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] dis = new int[n+1][n+1];

        for(int i=0; i<results.length; i++){
            dis[results[i][0]][results[i][1]]=1;
            dis[results[i][1]][results[i][0]]=-1;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    //i가 k를 이기고, k가 j를 이기면, i는 j를 이긴다.
                    if(dis[i][k]==1 && dis[k][j]==1){
                        dis[i][j]=1;
                        dis[j][i]=-1;
                    }

                    if(dis[i][k]==-1 && dis[k][j]==-1){
                        dis[i][j]=-1;
                        dis[j][i]=1;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            int cnt=0;
            for(int j=1; j<=n; j++){
                if(dis[i][j]!=0)    cnt++;
            }
            if(cnt==n-1)    answer++;
        }
        return answer;
    }
}