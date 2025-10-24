class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++)  graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for(int[] tmp : prerequisites) {
            graph.get(tmp[0]).add(tmp[1]);
            indegree[tmp[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0)  q.offer(i);
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i=0; i<graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)]==0)  q.offer(graph.get(now).get(i));
            }
        }

        boolean answer = true;
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]!=0) {
                answer = false;
                break;
            }
        }


        return answer;
    }
}