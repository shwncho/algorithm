import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Brick implements Comparable<Brick>{
    public int area, height, weight;
    Brick(int area, int height, int weight){
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o){
        return o.area - this.area;
    }
}
public class Main {
    static int[] dp;
    static List<Brick> list;


    public static int solution(){
        int answer=0;
        Collections.sort(list);
        dp[0]=list.get(0).height;
        answer=dp[0];
        for(int i=1; i<list.size(); i++){
            int max_h=0;
            for(int j=i-1; j>=0; j--){
                if(list.get(j).weight>list.get(i).weight && dp[j]>max_h){
                    max_h=dp[j];
                }
            }
            dp[i]=max_h+list.get(i).height;
            answer=Math.max(answer,dp[i]);

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        dp=new int[n];
        list=new ArrayList<>();

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Brick(area,height,weight));
        }

        System.out.println(solution());

    }
}
