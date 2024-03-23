import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        public int stage;
        public float fail;

        Node(int stage, float fail){
            this.stage = stage;
            this.fail = fail;
        }

        @Override
        public int compareTo(Node o){
            if(this.fail == o.fail)  return this.stage - o.stage;
            return Float.compare(o.fail,this.fail);
        }

    }
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        List<Node> result = new ArrayList<>();
        //실패율 기준 내림차순, 실패율 같을 경우 스테이지 번호 낮은 곳이 우선 순위

        int remainingPeople = stages.length;
        int[] stageNumber = new int[N+2];
        for(int s : stages){
            stageNumber[s]++;
        }


        for(int i=1; i<=N; i++){
            if(remainingPeople == 0){
                result.add(new Node(i,0));
                continue;
            }

            float fail = (float)stageNumber[i] / remainingPeople;
            remainingPeople -= stageNumber[i];

            result.add(new Node(i,fail));
        }

        Collections.sort(result);

        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).stage;
        }
        return answer;
    }
}