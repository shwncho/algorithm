// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    static class Fish{
        private int size, direction;

        Fish(int size, int direction){
            this.size = size;
            this.direction = direction;
        }

        public int getSize(){
            return this.size;
        }

        public int getDirection(){
            return this.direction;
        }
    }
    public int solution(int[] A, int[] B) {
        Stack<Fish> stk = new Stack<>();
        int answer = A.length;
        for(int i=0; i<A.length; i++){
            if(B[i]==1){
                stk.push(new Fish(A[i],B[i]));
            }
            else{
                while(!stk.isEmpty()){
                    answer--;
                    if(stk.peek().getSize() > A[i]){
                        break;
                    }
                    else{
                        stk.pop();
                    }

                }

            }

        }

        return answer;
    }
}