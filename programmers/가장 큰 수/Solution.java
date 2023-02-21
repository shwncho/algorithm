import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            arr[i]=String.valueOf(numbers[i]);
        }

        //내림차순 정렬로 큰 값이 앞으로
        Arrays.sort(arr,(o1,o2)->(o2+o1).compareTo(o1+o2));

        //0이 제일 크다 할 경우 return 0
        if(arr[0].equals("0"))  return "0";
        StringBuilder sb = new StringBuilder();

        for(String x : arr){
            sb.append(x);
        }

        return sb.toString();
    }
}