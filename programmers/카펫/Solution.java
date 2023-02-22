import java.util.*;
class Square{
    public int w,h;
    Square(int w, int h){
        this.w=w;
        this.h=h;
    }
}
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<Square> list = new ArrayList<>();
        // 사각형 총 갯수 = 넓이
        int s = brown + yellow;

        for(int i=3; i<=s; i++){
            if(s%i==0){
                if((s/i)<i) break;
                list.add(new Square(s/i,i));
            }
        }

        for(Square o : list){
            if(yellow==(o.w-2)*(o.h-2)){
                answer[0]=o.w;
                answer[1]=o.h;
                break;
            }
        }

        for(int x : answer){
            System.out.print(x+" ");
        }
        return answer;
    }
}