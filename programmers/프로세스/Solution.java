import java.util.*;
class Solution {

    static class Node{
        public int idx,rank;
        Node(int idx, int rank){
            this.idx=idx;
            this.rank=rank;
        }

    }
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> Q = new LinkedList<>();
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<priorities.length; i++){
            Q.offer(new Node(i,priorities[i]));
            pQ.offer(priorities[i]);
        }

        int cnt = 1;
        while(!Q.isEmpty()){
            Node now = Q.poll();

            if(now.idx == location && pQ.peek()==now.rank){
                answer = cnt;
                break;
            }

            if(pQ.peek() == now.rank){
                cnt++;
                pQ.poll();
            }
            else{
                Q.offer(now);
            }
        }

        return answer;
    }
}