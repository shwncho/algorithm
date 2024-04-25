// you can also use imports, for example:
import java.util.*;
import java.text.*;
import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String E, String L) {
        // Implement your solution here
        //입장료 2, 처음 한 시간 3, 그 다음 부터 4
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date e = sdf.parse(E);
            Date l = sdf.parse(L);

            long eTime = e.getTime();
            long lTime = l.getTime();
            long result = (lTime - eTime) / (1000 * 60);
            if(result > 60){
                result -= 60;
                return 5+((int)Math.ceil(result/60.0))*4;
            }
            else if(result<=60) return 5;

        } catch(ParseException e){
            e.printStackTrace();
        }


        return 0;
    }
}