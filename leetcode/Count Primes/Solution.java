class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1)    return 0;

        int cnt = 0;
        boolean[] num = new boolean[n];
        for(int i=2; i<n; i++) {
            if(!num[i]) {
                cnt++;
                for(int j=i; j<n; j+=i) num[j] = true;
            }
        }

        return cnt;
    }
}