import java.util.*;
class Node{
    Node prev;
    Node next;
    boolean deleted;
}
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        Node[] nodes = new Node[n];
        Stack<Node> recovery = new Stack<>();

        for(int i=0; i<n; i++){
            nodes[i] = new Node();
        }

        for(int i=0; i<n-1; i++){
            nodes[i+1].prev = nodes[i];
            nodes[i].next = nodes[i+1];
        }

        Node cur = nodes[k];

        for(String s : cmd){
            char c = s.charAt(0);

            if(c=='U'){
                int num = Integer.parseInt(s.substring(2));
                for(int i=0; i<num; i++){
                    cur=cur.prev;
                }
            }
            else if(c=='D'){
                int num = Integer.parseInt(s.substring(2));
                for(int i=0; i<num; i++){
                    cur=cur.next;
                }
            }
            else if(c=='C'){
                recovery.push(cur);
                cur.deleted = true;

                Node up = cur.prev;
                Node down = cur.next;

                if(up!=null){
                    up.next = down;
                }

                if(down!=null){
                    down.prev = up;
                    cur = down;
                }
                else    cur = up;

            }
            else{
                Node re = recovery.pop();
                re.deleted = false;

                Node up = re.prev;
                Node down = re.next;

                if(up!=null){
                    up.next = re;
                }
                if(down!=null){
                    down.prev = re;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Node tmp : nodes){
            if(tmp.deleted)   sb.append("X");
            else    sb.append("O");
        }
        answer = sb.toString();
        return answer;
    }
}