import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node>{
        int diff, num;
        Node(int diff, int num){
            this.diff = diff;
            this.num = num;
        }

        @Override
        public int compareTo(Node o){
            if(this.diff == o.diff)  return o.num - this.num;
            return this.diff - o.diff;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[11];
        for(int i=1; i<=10; i++){
            int val = Integer.parseInt(br.readLine());
            arr[i] = arr[i-1] + val;
        }

        List<Node> result = new ArrayList<>();
        for(int i=1; i<=10; i++){
            result.add(new Node(Math.abs(arr[i]-100),arr[i]));
        }

        Collections.sort(result);

        System.out.println(result.get(0).num);

    }
}
