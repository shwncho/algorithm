import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        //다리 위 트럭 무게
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }

        int weightOnBridge = 0;
        int time = 0;
        int idx = 0;

        while(!q.isEmpty()){

            weightOnBridge-=q.poll();

            if(idx==truck_weights.length){
                time+=bridge_length;
                break;
            }

            if(weightOnBridge + truck_weights[idx] <= weight){

                int now = truck_weights[idx];
                q.offer(now);
                weightOnBridge += now;
                idx++;
            }
            else    q.offer(0);


            time++;


        }
        answer = time;
        return answer;
    }
}