class Solution {
    public int equalPairs(int[][] grid) {
        int answer = 0;
        int n = grid.length;

        for(int i = 0; i<n; i++) {
            for (int j=0; j<n; j++) {
                boolean flag = true;
                for(int k = 0; k<n; k++) {
                    if(grid[i][k] != grid[k][j]){
                        flag = false;
                        break;
                    }
                }

                if(flag)    answer++;
            }
        }

        return answer;
    }
}