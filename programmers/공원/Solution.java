class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        int n = park.length;
        int m = park[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(park[i][j].equals("-1")) {
                    answer = Math.max(answer,BFS(mats,park,i,j));
                }
            }
        }

        return answer;
    }

    private int BFS(int[] mats, String[][] park, int x, int y) {
        int n = park.length;
        int m = park[0].length;

        int result = -1;
        for(int k : mats) {
            boolean isPossible = true;
            for(int i=x; i<x+k; i++) {
                if(i<0 || i>=n){
                    isPossible = false;
                    break;
                }
                for(int j=y; j<y+k; j++) {
                    if(j<0 || j>=m){
                        isPossible = false;
                        break;
                    }

                    if(!park[i][j].equals("-1")) {
                        isPossible = false;
                        break;
                    }
                }
            }
            if(isPossible)  result = Math.max(result, k);
        }


        return result;
    }
}