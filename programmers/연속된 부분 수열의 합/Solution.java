import java.util.*;
class Solution {

    static class Node implements Comparable<Node>{

        public int idx1, idx2, len;
        Node(int idx1, int idx2, int len){
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.len = len;
        }

        @Override
        public int compareTo(Node o){
            if(this.len == o.len)   return this.idx1 - o.idx1;
            return this.len - o.len;
        }
    }
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int start = 0;
        int end = 0;

        int n = sequence.length;
        int sum = sequence[start];
        List<Node> list = new ArrayList<>();

        while(start <= end && end<n){
            if(sum <= k){
                if(sum==k){
                    list.add(new Node(start,end,end-start+1));
                }
                end++;
                if(end==n)  break;
                sum+=sequence[end];
            }
            else if(sum > k){
                sum-=sequence[start];
                start++;
            }
        }

        Collections.sort(list);
        answer = new int[]{list.get(0).idx1,list.get(0).idx2};
        return answer;
    }
}