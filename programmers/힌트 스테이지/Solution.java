import java.util.*;
class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int answer = 0;

        // 스테이지 i로 진입
        // 힌트권 몇 개 있는지 판별
        // 힌트권 개수에 따른 비용 청구
        // 힌트 번들에서 현재 스테이지의 힌트권 번호 사는 경우 or 안사는 경우

        // 힌트권 관리 리스트 필요
        // 시간 복잡도 2^n * n 예상

        int n = cost.length;
        int k = hint[0].length;
        Map<Integer,Integer> getHint = new HashMap();
        for(int i=1; i<=n; i++) getHint.put(i,0);
        answer = DFS(n,k,cost,hint,getHint, 1, 0);


        return answer;
    }

    private int DFS(int n,int k, int[][] cost, int[][] hint, Map<Integer,Integer> getHint,
                    int stageNum, int total) {
        //종료조건
        if(stageNum == n) {
            return total + cost[n-1][Math.min(n-1,getHint.get(n))];
        }
        //현재스테이지 비용처리
        total += cost[stageNum-1][Math.min(n-1,getHint.get(stageNum))];


        Map<Integer,Integer> purchaseHint = new HashMap<>(getHint);
        for(int i=1; i<k; i++) {
            int num = hint[stageNum-1][i];
            purchaseHint.put(num,Math.min(n-1,purchaseHint.get(num)+1));
        }

        //힌트 구매하거나 or 안하거나
        int purchase = DFS(n,k,cost,hint,purchaseHint,
                stageNum+1, total + hint[stageNum-1][0]);
        int notPurchase = DFS(n,k,cost,hint,new HashMap<>(getHint),
                stageNum+1, total);

        return Math.min(purchase, notPurchase);

    }
}