class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        //도넛 -> 어느 정점에서 시작해도 n개 간선타고 자기 자신으로 돌아옴, 모든 정점이 in==out
        //막대 -> 특정 정점에서 시작해야 n-1개 간선타고 전체를 탐색, 
        //8자 -> 특정 정점이 2번 거침

        //생성한 정점 번호, 도넛 모양 그래프 수, 막대 모양 그래프 수, 8자 모양 그래프 수
        //생성한 정점 번호는 indegree가 0, outdegree가 2개 이상


        //생성한 정점 번호 찾기
        int n=0;
        for(int i=0; i<edges.length; i++){
            n = Math.max(n,Math.max(edges[i][0],edges[i][1]));
        }

        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int i=0; i<edges.length; i++){
            int in = edges[i][1];
            int out = edges[i][0];

            indegree[in]++;
            outdegree[out]++;
        }
        int createNode=0;
        for(int i=1; i<n+1; i++){
            if(indegree[i]==0 && outdegree[i]>=2)  createNode=i;
        }


        // 생성된 정점으로부터 연결된 간선 삭제
        int graphCnt = 0;
        for(int i=0; i<edges.length; i++){
            if(edges[i][0]==createNode){
                indegree[edges[i][1]]--;
                graphCnt++;
            }
        }

        //그래프 개수 계산
        int dCnt = 0;
        int stickCnt = 0;
        int eightCnt = 0;

        for(int i=1; i<n+1; i++){
            if(i==createNode)   continue;

            //size가 1인 막대인경우 나중에 절반으로 나눠야하므로 2를 더함
            if(indegree[i]==0 && outdegree[i]==0)  stickCnt+=2;
            else if(indegree[i]==0 || outdegree[i]==0)   stickCnt++;

            if(indegree[i]==2 && outdegree[i]==2)   eightCnt++;
        }

        stickCnt = stickCnt/2;
        dCnt = graphCnt - stickCnt - eightCnt;



        answer[0]=createNode;
        answer[1]=dCnt;
        answer[2]=stickCnt;
        answer[3]=eightCnt;
        return answer;
    }
}