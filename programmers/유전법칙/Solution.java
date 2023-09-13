class Solution {
    public String[] solution(int[][] queries) {
        int n = queries.length;
        String[] answer = new String[n];


        for(int i=0; i<n; i++){
            int[] q = queries[i];
            answer[i]=recur(q[0],q[1]);
        }

        return answer;
    }

    public static String recur(int generation, int order){
        if(generation==1)   return "Rr";

        String parent = recur(generation-1, (order-1)/4+1);
        if(parent.equals("RR") || parent.equals("rr"))  return parent;

        if(order%4==0)  return "rr";
        else if(order%4==1) return"RR";
        else    return "Rr";
    }
}