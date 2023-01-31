import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    public int s,e;
    Point(int s, int e){
        this.s=s;
        this.e=e;
    }

    @Override
    public int compareTo(Point p){
        return this.s-p.s;
    }

}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int[] index = new int[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Point(a,b));
        }

        Collections.sort(list);

        //비교를 위해 삽입
        answer.add(Integer.MIN_VALUE);
        for(int i=0; i<n; i++){
            int key = list.get(i).e;

            if(answer.get(answer.size()-1) < key){
                answer.add(key);
                index[i]=answer.size()-1;
            }
            else{
                int left = 1;
                int right = answer.size()-1;

                while(left<right){

                    int mid = (left+right)/2;
                    if(answer.get(mid) < key)   left=mid+1;
                    else right=mid;
                }
                answer.set(right,key);
                index[i]=right;
            }
        }

        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        sb.append(n-(answer.size()-1)).append("\n");
        int idx=answer.size()-1;

        for(int i=n-1; i>=0; i--){

            if(idx == index[i]){
                idx--;
            }
            else stk.push(list.get(i).s);

        }

        while(!stk.isEmpty()){
            sb.append(stk.pop()).append("\n");
        }

        System.out.println(sb);

    }
}
