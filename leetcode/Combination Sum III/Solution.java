class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    private int[] num = new int[]{1,2,3,4,5,6,7,8,9};
    private void DFS(int s, int L, int k, int n, int[] comb) {
        if(L==k) {
            int sum = 0;
            List<Integer> tmp = new ArrayList<>();
            for(int i : comb) {
                sum += i;
            }
            if(sum == n) {
                for(int i : comb) tmp.add(i);
                answer.add(tmp);
            }
            return;
        }

        for(int i=s; i<9; i++){
            comb[L] = num[i];
            DFS(i+1,L+1,k,n,comb);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        DFS(0,0,k,n,new int[k]);

        return answer;
    }
}