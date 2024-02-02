import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        List<Integer> answer = new ArrayList<>();

        int prev = 10;
        for(int value : arr){
            if(prev != value){
                prev = value;
                answer.add(value);
            }
        }


        return answer
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }
}