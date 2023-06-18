import java.util.*;
import java.io.*;
class Node{
    char data;
    Node l,r;

    Node(char val){
        this.data=val;
        l=r=null;
    }


}
public class Main {
    static Node head = new Node('A');

    public static void preOrder(Node node){
        if(node==null)  return;
        else{
            System.out.print(node.data);
            preOrder(node.l);
            preOrder(node.r);
        }
    }

    public static void inOrder(Node node){
        if(node==null) return;
        else{
            inOrder(node.l);
            System.out.print(node.data);
            inOrder(node.r);
        }
    }

    public static void postOrder(Node node){
        if(node==null)  return;
        else{
            postOrder(node.l);
            postOrder(node.r);
            System.out.print(node.data);
        }
    }

    public static void insertNode(Node tmp, char root, char left, char right){
        if(tmp.data == root){
            tmp.l = (left=='.' ? null : new Node(left));
            tmp.r = (right=='.' ? null : new Node(right));
        }
        else{
            if(tmp.l != null) insertNode(tmp.l, root, left, right);
            if(tmp.r != null) insertNode(tmp.r, root, left, right);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=1; i<n; i++){
            st=new StringTokenizer(br.readLine());
            char root=st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right= st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);



    }
}
