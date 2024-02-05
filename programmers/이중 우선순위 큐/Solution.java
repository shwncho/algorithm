import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer;

        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minpq = new PriorityQueue<>();

        for(String s : operations){
            String command = s.split(" ")[0];
            String number = s.split(" ")[1];

            if(command.equals("I")){
                int value = Integer.parseInt(number);
                maxpq.offer(value);
                minpq.offer(value);
            }
            else if(s.equals("D 1")){
                minpq.remove(maxpq.poll());
            }
            else if(s.equals("D -1")){
                maxpq.remove(minpq.poll());
            }
        }

        if(minpq.isEmpty() && maxpq.isEmpty()){
            answer = new int[]{0,0};
        }
        else{
            answer = new int[]{maxpq.poll(), minpq.poll()};
        }


        return answer;
    }
}