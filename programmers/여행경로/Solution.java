import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();
    public static void DFS(String start, String route,
                           int cnt, String[][] tickets)
    {
        //모든 경로 탐색
        if(cnt==tickets.length){
            //모든 경로 탐색 완료한 루트 리스트에 담기
            list.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            //시작 지점이 같아야하고, 방문한 경로가 아니여야 한다.
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i]=true;
                DFS(tickets[i][1], route+" "+tickets[i][1], cnt+1, tickets);
                visited[i]=false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited=new boolean[tickets.length];

        DFS("ICN","ICN",0,tickets);
        //가능한 경로중 알파벳순으로 정렬하면 사전 순서의 경로로 정렬됨
        Collections.sort(list);

        answer=list.get(0).split(" ");

        return answer;
    }
}