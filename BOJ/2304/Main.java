import java.util.*;
import java.io.*;
public class Main {

    static class Square implements Comparable<Square>{
        int l,h;
        Square(int l, int h){
            this.l=l;
            this.h=h;
        }

        @Override
        public int compareTo(Square o){
            return this.l - o.l;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Square> list = new ArrayList<>();


        int maxL = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            maxL = Math.max(maxL, l);
            list.add(new Square(l,h));


        }

        Collections.sort(list);

        int[] squares = new int[maxL+1];

        for(Square s : list){
            squares[s.l]=s.h;
        }

        int[] leftMax = new int[maxL+1];
        int[] rightMax = new int[maxL+1];

        int tmpMax = Integer.MIN_VALUE;
        for(int i=0; i<maxL+1; i++){
            tmpMax = Math.max(tmpMax,squares[i]);
            leftMax[i]=tmpMax;
        }

        tmpMax = Integer.MIN_VALUE;
        for(int i=maxL; i>=0; i--){
            tmpMax = Math.max(tmpMax, squares[i]);
            rightMax[i]=tmpMax;
        }


        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<maxL+1; i++) answer.add(Math.min(leftMax[i], rightMax[i]));

        System.out.println(answer.stream().mapToInt(i->i).sum());

    }
}
