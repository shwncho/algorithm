import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Brick implements Comparable<Brick>{
    public int a,h,w,no;
    Brick(int a,int h,int w,int no){
        this.a=a;
        this.h=h;
        this.w=w;
        this.no=no;
    }

    @Override
    public int compareTo(Brick o){
        return o.a-this.a;
    }
}
public class Main {
    static int n;
    static ArrayList<Brick> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Brick(a,b,c,i+1));
        }

        Collections.sort(list);
        int[] dp = new int[n];
        dp[0]=list.get(0).h;
        int max = list.get(0).h;
        for(int i=1; i<n; i++){
            int max_h=0;
            for(int j=i-1; j>=0; j--){
                if(list.get(j).w>list.get(i).w && dp[j]>max_h){
                    max_h=dp[j];
                }
            }
            dp[i]=max_h+list.get(i).h;
            max = Math.max(max,dp[i]);
        }

        StringBuilder sb = new StringBuilder();
        int cnt=0;
        while(n>=1){
            if(dp[n-1]==max){
                sb.append(list.get(n-1).no).append("\n");
                cnt++;
                max-=list.get(n-1).h;
            }
            n--;
        }
        System.out.println(cnt);
        System.out.println(sb);

    }
}
