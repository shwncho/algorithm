class Solution {
    private class Node {
        String s;
        double v;
        Node(String s, double v) {
            this.s = s;
            this.v = v;
        }
    }
    private double DFS(Map<String,List<Node>> graph,Set<String> visited, String a, String b, double acc) {
        // 목적 노드에 도달했으면 누적 값(acc)을 반환
        if (a.equals(b)) return acc;

        visited.add(a);

        for (Node next : graph.get(a)) {
            if (visited.contains(next.s)) continue;
            double result = DFS(graph, visited, next.s, b, acc * next.v);
            if (result != -1.0) return result; // 유효한 경로를 찾으면 반환
        }

        return -1.0; // 도달 불가
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Node>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Node(b, val));
            graph.get(b).add(new Node(a, 1 / val));
        }

        int n = queries.size();
        double[] answer = new double[n];

        for(int i=0; i<n; i++) {
            List<String> q = queries.get(i);
            if(q.get(0).equals(q.get(1)) && graph.containsKey(q.get(0))) {
                answer[i]=1;
                continue;
            }
            else if(!graph.containsKey(q.get(0)) || !graph.containsKey(q.get(1))) {
                answer[i] =-1;
                continue;
            }


            answer[i]=DFS(graph,new HashSet<>(), q.get(0), q.get(1),1);
        }

        return answer;
    }
}