/**
 * 원래 최단경로는 BFS가 맞으나 DFS를 공부하는김에 해본다.
 * DFS로 최단경로를 구하려면 노드의 자식이 2개라는 것이 전제조건임
 */

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}


public class Main {
    Node root;
    //L은 Level, root노드의 Level을 return하면 최단경로
    public int DFS(int L, Node root){
        if(root.lt==null && root.rt==null)  return L;
        else return Math.min(DFS(L+1, root.lt),DFS(L+1, root.rt));
    }
    public static void main(String[] args) {
        Main tree = new Main();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        System.out.println(tree.DFS(0,tree.root));
    }
}
