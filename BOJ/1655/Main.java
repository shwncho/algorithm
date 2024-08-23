import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            int val = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size())    maxHeap.offer(val);
            else minHeap.offer(val);

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
                if(minHeap.peek() < maxHeap.peek()){
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }

}
