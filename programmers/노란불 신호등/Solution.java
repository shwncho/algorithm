class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int n = signals.length;

        //각 신호등별 한바퀴 사이클 구하기
        int[] sum = new int[n];
        for(int i=0; i<n; i++) {
            int s = 0;
            for(int j=0; j<3; j++) {
                s += signals[i][j];
            }

            sum[i] = s;
        }

        // 각 신호등 사이클의 주기를 통한 최소 사이클 -> 전체 탐색 범위 
        int lcm = 1;
        for(int i=0; i<n; i++) {
            lcm = lcm(lcm, sum[i]);
        }

        //탐색
        for(int t=1; t<=lcm; t++) {
            boolean isAllYellow = true;
            for(int i=0; i<n; i++) {
                // mod 연산은 0이 되는 경우를 고려하여 t-1로 계산
                int cycle = (t-1) % sum[i];

                if(!(cycle >= signals[i][0] && cycle < signals[i][0] + signals[i][1])) {
                    isAllYellow = false;
                    break;
                }
            }

            if(isAllYellow) return t;
        }

        return -1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    private int lcm (int a, int b) {
        return (a * b) / gcd(a,b);
    }
}