class Solution {
    private long mergeSortAndCountInversions(int[] A, int[] temp, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        long inversions = 0;

        inversions += mergeSortAndCountInversions(A, temp, start, mid);
        inversions += mergeSortAndCountInversions(A, temp, mid + 1, end);

        inversions += mergeAndCountSplitInversions(A, temp, start, mid, end);

        return inversions;
    }

    private long mergeAndCountSplitInversions(int[] A, int[] temp, int start, int mid, int end) {
        long inversions = 0;
        int i = start, j = mid + 1, k = start;

        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
                inversions += mid - i + 1; // Count inversions
            }
        }

        while (i <= mid) {
            temp[k++] = A[i++];
        }

        while (j <= end) {
            temp[k++] = A[j++];
        }

        for (i = start; i <= end; i++) {
            A[i] = temp[i];
        }

        return inversions;
    }

    public int solution(int[] A) {
        int[] temp = new int[A.length];
        long inversions = mergeSortAndCountInversions(A, temp, 0, A.length - 1);

        if (inversions > 1_000_000_000) {
            return -1;
        }

        return (int) inversions;
    }
}
