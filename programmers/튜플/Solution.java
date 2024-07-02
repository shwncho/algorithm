import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        int n,cnt;
        Node(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            return o.cnt - this.cnt;
        }
    }
    public int[] solution(String s) {
        int[] answer = {};

        s=s.replaceAll("\\{","");
        s=s.replaceAll("\\}","");

        String[] str = s.split(",");


        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<str.length; i++){
            int val = Integer.parseInt(str[i]);
            map.put(val, map.getOrDefault(val,0)+1);
        }

        answer = new int[map.size()];
        List<Node> list = new ArrayList<>();

        for(int x : map.keySet()){
            list.add(new Node(x,map.get(x)));
        }

        Collections.sort(list);

        int idx = 0;
        for(Node now : list){
            answer[idx++] = now.n;
        }

        return answer;
    }
}