import java.util.*;
import java.io.*;
public class Main {

    static class Point implements Comparable<Point>{
        public int x,c;
        Point(int x, int c){
            this.x=x;
            this.c=c;
        }

        @Override
        public int compareTo(Point o){
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Point(x,c));
        }

        Collections.sort(list);

        int answer = 0;

        for(int i=0; i<N; i++){

            int left = Integer.MAX_VALUE;
            int lIdx = i-1;
            while(lIdx>=0){
                if(list.get(lIdx).c == list.get(i).c){
                    left = list.get(i).x - list.get(lIdx).x;
                    break;
                }
                else lIdx--;
            }

            int right = Integer.MAX_VALUE;
            int rIdx = i+1;
            while(rIdx<N){
                if(list.get(rIdx).c == list.get(i).c){
                    right = list.get(rIdx).x - list.get(i).x;
                    break;
                }
                else rIdx++;
            }

            answer += Math.min(left,right);
        }

        System.out.println(answer);
    }
}
