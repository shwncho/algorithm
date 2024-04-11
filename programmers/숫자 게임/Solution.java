import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int ptrA = 0;
        int ptrB = 0;

        while(ptrA<n && ptrB<n){
            if(A[ptrA] < B[ptrB]){
                answer++;
                ptrA++;
                ptrB++;
            }
            else{
                ptrB++;
            }
        }


        return answer;
    }
}