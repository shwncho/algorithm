import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        int left,right,distance;
        Node(int left, int right, int distance){
            this.left=left;
            this.right=right;
            this.distance=distance;
        }

        @Override
        public int compareTo(Node o){
            if(this.distance == o.distance)
                return this.left - o.left;
            return this.distance - o.distance;
        }

    }
    static List<Node> result = new ArrayList<>();
    public int[] solution(String[] gems) {
        int[] answer = {};

        Set<String> gemSet = new HashSet<>();
        for(String g : gems){
            gemSet.add(g);
        }
        int size = gemSet.size();

        Map<String,Integer> map = new HashMap<>();


        int left = 0;
        int right = 0;

        map.put(gems[0],1);

        while(left <= right && right< gems.length){

            //모든 보석이 담겼을 때
            if(map.size() == size){
                result.add(new Node(left+1, right+1, right-left+1));
                map.put(gems[left],map.get(gems[left])-1);
                if(map.get(gems[left])==0){
                    map.remove(gems[left]);
                }
                left++;
            }

            else{
                right++;

                if(right==gems.length)  break;

                map.put(gems[right],map.getOrDefault(gems[right],0)+1);
            }
        }
        Collections.sort(result);
        answer = new int[]{result.get(0).left, result.get(0).right};
        return answer;
    }
}