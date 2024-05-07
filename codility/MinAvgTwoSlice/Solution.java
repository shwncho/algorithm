// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {

        int minAvgStartIdx = 0;
        double minAvg = Integer.MAX_VALUE;

        for(int i=0; i<A.length-2; i++){
            double minAvgWithTwoElements = (A[i] + A[i+1]) / 2.0;
            if(minAvg > minAvgWithTwoElements){
                minAvg = minAvgWithTwoElements;
                minAvgStartIdx = i;
            }
            //배열의 원소가 5개인경우 2개 3개로 나눠진 평균도 비교해야하기 때문에 3개의 원소의 평균값도 계산
            double minAvgWithThreeElements = (A[i] + A[i+1] + A[i+2]) / 3.0;
            if(minAvg > minAvgWithThreeElements){
                minAvg = minAvgWithThreeElements;
                minAvgStartIdx = i;
            }
        }

        double lastMinAvg = (A[A.length-2] + A[A.length-1]) / 2.0;
        if(minAvg > lastMinAvg){
            minAvgStartIdx = A.length-2;
        }

        return minAvgStartIdx;
    }
}