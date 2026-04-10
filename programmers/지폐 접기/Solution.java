class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        if(wallet[0] >= bill[0] && wallet[1] >= bill[1])    return 0;

        while(true){
            answer++;
            if(bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;

                //그대로 or 90도 돌려서
                if(wallet[0] >= bill[0] && wallet[1] >= bill[1] ||
                        wallet[0] >= bill[1] && wallet[1] >= bill[0]
                ) {
                    break;
                }
            }
            else {
                bill[1] = bill[1] / 2;

                //그대로 or 90도 돌려서
                if(wallet[0] >= bill[0] && wallet[1] >= bill[1] ||
                        wallet[0] >= bill[1] && wallet[1] >= bill[0]
                ) {
                    break;
                }
            }
        }

        return answer;
    }
}