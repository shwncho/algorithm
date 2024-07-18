import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node>{
        int absValue,originValue;
        Node(int absValue, int originValue){
            this.absValue = absValue;
            this.originValue = originValue;
        }

        @Override
        public int compareTo(Node o){
            if(this.absValue == o.absValue) return this.originValue - o.originValue;
            return this.absValue - o.absValue;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        Queue<Node> pQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            int value = Integer.parseInt(br.readLine());

            if(value==0 && pQ.isEmpty())    sb.append(0).append("\n");
            else if(value == 0){
                sb.append(pQ.poll().originValue).append("\n");
            }
            else{
                pQ.offer(new Node(Math.abs(value),value));
            }
        }



        System.out.println(sb);
    }
}
