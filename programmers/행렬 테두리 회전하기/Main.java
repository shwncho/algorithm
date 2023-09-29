import java.util.*;
class Solution {
    static ArrayList<Integer> result = new ArrayList<>();
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer;

        int[][] graph = new int[rows][columns];

        int num=1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                graph[i][j]=num++;
            }
        }


        for(int[] query : queries){
            int qx1 = query[0]-1;
            int qy1 = query[1]-1;

            int qx2 = query[2]-1;
            int qy2 = query[3]-1;

            int[][] nextGraph = rotate(graph,qx1,qy1,qx2,qy2);
            graph=nextGraph.clone();

        }



        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static int[][] rotate(int[][] graph, int qx1, int qy1, int qx2, int qy2){
        ArrayList<Integer> list = new ArrayList<>();

        int tmp1 = graph[qx1][qy1];
        int tmp2;
        for(int i=qy1+1; i<=qy2; i++){
            tmp2=graph[qx1][i];
            graph[qx1][i]=tmp1;
            tmp1=tmp2;

            list.add(tmp2);
        }

        for(int i=qx1+1; i<=qx2; i++){
            tmp2=graph[i][qy2];
            graph[i][qy2]=tmp1;
            tmp1=tmp2;

            list.add(tmp2);

        }

        for(int i=qy2-1; i>=qy1; i--){
            tmp2=graph[qx2][i];
            graph[qx2][i]=tmp1;
            tmp1=tmp2;

            list.add(tmp2);

        }

        for(int i=qx2-1; i>=qx1; i--){
            tmp2 = graph[i][qy1];
            graph[i][qy1]=tmp1;
            tmp1=tmp2;

            list.add(tmp2);

        }

        result.add(Collections.min(list));

        return graph;
    }



}