class Solution {
    private class Node implements Comparable<Node> {
        int n1,n2,lastIdx;
        Node(int n1, int n2, int lastIdx) {
            this.n1 = n1;
            this.n2 = n2;
            this.lastIdx = lastIdx;
        }

        @Override
        public int compareTo(Node o){
            return (this.n1+this.n2) - (o.n1 + o.n2);
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0; i<k; i++)  answer.add(new ArrayList<>());

        Queue<Node> pQ = new PriorityQueue<>();

        for(int x : nums1)  pQ.offer(new Node(x,nums2[0],0));

        for(int i=0; i<k && !pQ.isEmpty(); i++){
            Node now = pQ.poll();
            answer.get(i).add(now.n1);
            answer.get(i).add(now.n2);
            if(now.lastIdx < nums2.length -1)
                pQ.offer(new Node(now.n1,nums2[now.lastIdx+1],now.lastIdx+1));
        }


        return answer;
    }
}