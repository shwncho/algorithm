import java.util.*;

class Solution {
    public int solution(int K, int M, int[] A) {
        int left = Arrays.stream(A).max().getAsInt();
        int right = Arrays.stream(A).sum();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isDivisible(K, mid, A)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isDivisible(int K, int targetSum, int[] A) {
        int blocks = 1;
        int currentSum = 0;

        for (int num : A) {
            currentSum += num;
            if (currentSum > targetSum) {
                blocks++;
                currentSum = num;
            }
        }

        return blocks <= K;
    }
}