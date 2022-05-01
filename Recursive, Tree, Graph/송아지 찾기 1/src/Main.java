import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int data;
    Node lt,ct,rt;
    public Node(int val){
        data=val;
        lt=ct=rt=null;
    }
}
public class Main {
    Node root;
    public String BFS(Node root, int target){
        Queue<Node> queue = new LinkedList<>();
        int L=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            Node tmp =queue.poll();
            int key = tmp.data;
            if(key==target) break;
            tmp.lt=new Node(key+1);
            tmp.ct=new Node(key-1);
            tmp.rt=new Node(key+5);

            queue.offer(tmp.lt);
            queue.offer(tmp.ct);
            queue.offer(tmp.rt);

            L=(int)(Math.log10(queue.size()) / Math.log10(3));
        }
        return String.valueOf(L);


    }
    public static void main(String[] args) throws IOException {
        Main tree = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        tree.root=new Node(num);

        bw.write(tree.BFS(tree.root,target));
        bw.flush();

        br.close();
        bw.close();
    }
}
