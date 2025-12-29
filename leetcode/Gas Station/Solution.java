class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;  // 전체 가스 - 전체 비용
        int tank = 0;   // 현재 누적 연료
        int start = 0;  // 시작점 후보

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            // 현재 지점까지 올 수 없다면
            if (tank < 0) {
                // start ~ i 까지는 전부 시작 불가
                start = i + 1;
                tank = 0;
            }
        }

        // 전체 가스가 부족하면 불가능
        return total >= 0 ? start : -1;
    }
}