import java.io.*;
import java.util.*;
public class Main {
    static class Time implements Comparable<Time>{
        int s,e,number;
        Time(int s, int e, int number){
            this.s = s;
            this.e = e;
            this.number = number;
        }

        @Override
        public int compareTo(Time o){
            return this.e - o.e;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Time(s,e,0));
        }
        //들어오는 순서대로 정렬
        Collections.sort(list, (o1,o2) -> o1.s - o2.s);

        //현재 컴퓨터 이용중인 큐
        Queue<Time> pQ = new PriorityQueue<>();

        //컴퓨터 번호와 사용횟수
        Map<Integer,Integer> numbers = new HashMap<>();

        //컴퓨터 사용이 끝나고 비어있는 컴퓨터 번호 큐
        Queue<Integer> q = new PriorityQueue<>();
        int id = 1;

        for(int i=0; i<N; i++){
            //컴퓨터 이용중이 없거나 새로 컴퓨터를 늘려야 할 때
            if(pQ.isEmpty() || pQ.peek().e > list.get(i).s){
                //컴퓨터 사용이 끝나고 비어있는 자리가 있으면
                if(!q.isEmpty()){
                    int num = q.poll();
                    pQ.offer(new Time(list.get(i).s,list.get(i).e,num));
                    numbers.put(num,numbers.get(num)+1);
                    continue;
                }
                pQ.offer(new Time(list.get(i).s, list.get(i).e, id));
                numbers.put(id,numbers.getOrDefault(id, 0)+1);
                id++;
            }
            //이용중인 컴퓨터가 종료된 시간 이후로 시작 시간이 들어올 경우
            else{
                Time now;
                while(!pQ.isEmpty() && pQ.peek().e < list.get(i).s){
                    now = pQ.poll();
                    //비어있는 컴퓨터 번호 담기
                    q.offer(now.number);
                }
                //제일 컴퓨터 번호가 작은 값 담기
                int min = q.poll();
                pQ.offer(new Time(list.get(i).s,list.get(i).e,min));
                numbers.put(min,numbers.get(min)+1);
            }

        }

        System.out.println(id-1);
        for(int i=1; i<=numbers.size(); i++){
            System.out.print(numbers.get(i)+" ");
        }
    }
}
