class SmallestInfiniteSet {
    private int curr;
    private Queue<Integer> pQ;
    private Set<Integer> s;

    public SmallestInfiniteSet() {
        curr = 1;
        pQ = new PriorityQueue<>();
        s = new HashSet<>();
    }

    public int popSmallest() {
        if(!pQ.isEmpty()){
            int res = pQ.poll();
            s.remove(res);
            return res;
        }
        return curr++;
    }

    public void addBack(int num) {
        if(num < curr && !s.contains(num)){
            pQ.offer(num);
            s.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */