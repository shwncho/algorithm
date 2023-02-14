class Solution {
    // 가로 or 세로를 기준으로 잡고 비교
    public int solution(int[][] sizes) {
        int answer = 0;

        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;

        for(int[] tmp : sizes){
            int w = tmp[0];
            int h = tmp[1];

            if(w<h){
                int t = w;
                w = h;
                h = t;
            }

            wMax = Math.max(wMax, w);
            hMax = Math.max(hMax, h);

        }
        answer = wMax * hMax;


        return answer;
    }
}
