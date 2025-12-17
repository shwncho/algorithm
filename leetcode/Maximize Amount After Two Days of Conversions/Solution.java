class Solution {
    private class Node {
        String c;
        double r;
        Node(String c, double r) {
            this.c = c;
            this.r = r;
        }
    }
    private Map<String, List<Node>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, List<Node>> result = new HashMap<>();
        for(int i=0; i<pairs.size(); i++) {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double val = rates[i];

            result.putIfAbsent(from, new ArrayList<>());
            result.putIfAbsent(to, new ArrayList<>());

            result.get(from).add(new Node(to,val));
            result.get(to).add(new Node(from,1/val));
        }
        return result;
    }

    private Map<String,Double> BFS(String start, Map<String,List<Node>> graph) {
        Map<String,Double> best = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start,1.0));
        best.put(start,1.0);

        while(!q.isEmpty()) {
            Node now = q.poll();
            double nowRate = best.get(now.c);
            //Day2에 계산할 때, day1의 best로 탐색하므로 존재하지않는 currency가 있을 수 있어서 초기화 해야함
            for(Node next : graph.getOrDefault(now.c,List.of())) {
                double newRate = nowRate * next.r;
                if(newRate > best.getOrDefault(next.c,0.0)){
                    best.put(next.c,newRate);
                    q.offer(new Node(next.c,newRate));
                }
            }
        }
        return best;
    }
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        double answer = 1;

        Map<String, List<Node>> g1 = buildGraph(pairs1,rates1);
        Map<String, List<Node>> g2 = buildGraph(pairs2,rates2);

        Map<String,Double> bestOfDay1 = BFS(initialCurrency, g1);

        for(String currency : bestOfDay1.keySet()) {
            Map<String, Double> bestOfDay2 = BFS(currency, g2);
            double back = bestOfDay2.getOrDefault(initialCurrency, 0.0);
            answer = Math.max(answer, bestOfDay1.get(currency) * back);
        }


        return answer;
    }
}