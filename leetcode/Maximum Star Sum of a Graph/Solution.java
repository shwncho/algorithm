class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        int answer = Integer.MIN_VALUE;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        for(int i=0; i<n; i++) {
            List<Integer> list = graph.get(i);
            list.sort((a,b) -> (vals[b] - vals[a]));

            int sum = vals[i];
            answer = Math.max(answer, vals[i]);
            for(int j=0; j<k && j<list.size(); j++) {
                sum+=vals[list.get(j)];
                answer= Math.max(answer, sum);
            }

        }

        return answer;

    }
}