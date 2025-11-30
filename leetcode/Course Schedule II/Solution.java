class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] arr = new int[numCourses];
        int[] result = new int[numCourses];

        for(int i=0; i<numCourses; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for(int[] tmp : prerequisites){
            graph.get(tmp[0]).add(tmp[1]);
            indegree[tmp[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0)  q.offer(i);
        }

        int idx = 0;
        while(!q.isEmpty()) {
            int now = q.poll();

            arr[idx++] = now;

            for(int i=0; i<graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)]==0)
                    q.offer(graph.get(now).get(i));
            }
        }

        for(int i=0; i<numCourses; i++) {
            if(indegree[i]!=0)  return new int[]{};
        }

        for(int i=0; i<numCourses; i++) {
            result[i] = arr[numCourses-i-1];
        }
        return result;
    }
}