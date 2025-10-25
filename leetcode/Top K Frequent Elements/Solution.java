class Solution {
    class Node implements Comparable<Node> {
        int num,cnt;
        Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return o.cnt - this.cnt;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];

        Map<Integer,Integer> map = new HashMap();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        List<Node> list = new ArrayList<>();
        for(int tmp : map.keySet()){
            list.add(new Node(tmp,map.get(tmp)));
        }

        Collections.sort(list);

        for(int i=0; i<k; i++)  answer[i] = list.get(i).num;
        return answer;
    }
}