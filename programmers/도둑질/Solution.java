//이차원 배열로 풀면 시간 초과
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        int[] case1 = new int[n];
        int[] case2 = new int[n];

        for(int i=0; i<n; i++){
            case1[i] = money[i];
            case2[i] = money[i];
        }

        case1[n-1]=0;
        case1[1]=case1[0];

        case2[0]=0;

        for(int i=2; i<n; i++){
            case1[i] = Math.max(case1[i-1], case1[i-2]+case1[i]);
            case2[i] = Math.max(case2[i-1], case2[i-2]+case2[i]);
        }

        answer = Math.max(case1[n-1], case2[n-1]);

        return answer;
    }
}