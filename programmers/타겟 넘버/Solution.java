class Solution {
    static int answer=0;
    static int n;
    static int t;
    public static void DFS(int L, int sum, int[] arr){
        if(L==n){
            if(sum==t) answer++;
        }
        else{
            DFS(L+1, sum+arr[L],arr);
            DFS(L+1, sum-arr[L],arr);
        }
    }
    public int solution(int[] numbers, int target) {
        n=numbers.length;
        t=target;
        DFS(0,0,numbers);


        return answer;
    }
}