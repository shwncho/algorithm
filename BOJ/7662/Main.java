import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minpq = new PriorityQueue<>();
            //원소 개수 관리 map
            Map<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());
                if(command.equals("I")){
                    maxpq.offer(number);
                    minpq.offer(number);
                    map.put(number, map.getOrDefault(number,0)+1);
                }
                else if(command.equals("D") && number==1){
                    remove(maxpq,map);
                }
                else if(command.equals("D") && number==-1){
                    remove(minpq,map);
                }
            }
            if(map.size()==0){
                sb.append("EMPTY").append("\n");
            }
            else{
                int value = remove(maxpq,map);
                sb.append(value).append(" ");
                if(map.size()>0)    value = remove(minpq,map);
                sb.append(value).append("\n");
            }
        }

        System.out.println(sb);
    }
    private static int remove(PriorityQueue<Integer> pq, Map<Integer,Integer> map){
        int value=0;
        while(true){
            if(pq.size()==0)    break;
            value = pq.poll();
            //map에서 이미 제거되서 null인 경우 0으로 디폴트 설정
            int res = map.getOrDefault(value,0);
            if(res==0)   continue;
            else if(map.get(value)==1)  map.remove(value);
            else{
                map.put(value,res-1);
            }
            break;
        }
        return value;
    }
}
