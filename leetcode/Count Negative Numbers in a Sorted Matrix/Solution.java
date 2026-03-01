class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int answer = 0;
        for(int i=0; i<m; i++) {
            if(grid[i][n-1]>=0)    continue;
            answer+=binarySearch(grid[i]);
        }

        return answer;
    }

    private int binarySearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= 0)   left=mid +1;
            else    right = mid;
        }

        return arr.length - left;
    }
}