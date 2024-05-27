import java.util.*;
class Solution {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int leftPosition,rightPosition;
    static Map<Integer,Point> position = new HashMap<>();
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        position.put(1,new Point(1,1));
        position.put(2,new Point(1,2));
        position.put(3,new Point(1,3));
        position.put(4,new Point(2,1));
        position.put(5,new Point(2,2));
        position.put(6,new Point(2,3));
        position.put(7,new Point(3,1));
        position.put(8,new Point(3,2));
        position.put(9,new Point(3,3));
        position.put(0,new Point(4,2));
        //*에 해당
        position.put(10,new Point(4,1));
        //#에 해당
        position.put(11,new Point(4,3));

        leftPosition = 10;
        rightPosition = 11;

        for(int num : numbers){
            calculate(num,hand,answer);
        }

        return answer.toString();
    }
    //거리계산 메서드
    private void calculate(int num, String hand, StringBuilder answer){
        if(num == 1 || num == 4 || num == 7){
            answer.append("L");
            leftPosition = num;
            return;
        }
        else if(num == 3 || num == 6 || num == 9){
            answer.append("R");
            rightPosition = num;
            return;
        }

        int x = position.get(num).x;
        int y = position.get(num).y;
        int leftDistance = Math.abs(position.get(leftPosition).x - x) +
                Math.abs(position.get(leftPosition).y - y);
        int rightDistance = Math.abs(position.get(rightPosition).x - x)+
                Math.abs(position.get(rightPosition).y - y);

        if(leftDistance > rightDistance){
            answer.append("R");
            rightPosition = num;
        }
        else if(leftDistance < rightDistance){
            answer.append("L");
            leftPosition = num;
        }
        else{
            if(hand.equals("right")){
                answer.append("R");
                rightPosition = num;
            }
            else{
                answer.append("L");
                leftPosition = num;
            }
        }
    }
}