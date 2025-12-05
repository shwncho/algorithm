class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                pQ.offer(matrix[i][j]);
                if(pQ.size()>k) pQ.poll();
            }
        }

        return pQ.poll();
    }
}