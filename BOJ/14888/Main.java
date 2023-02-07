import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Character> list = new ArrayList<>();
    static int[] pm,arr,ch;
    public static void DFS(int L){
        if(L==n-1){
            int tmp=num[0];
            for(int i=0; i<n-1; i++){
                if(list.get(pm[i])=='+'){
                    tmp+=num[i+1];
                }
                else if(list.get(pm[i])=='-'){
                    tmp-=num[i+1];
                }
                else if(list.get(pm[i])=='*'){
                    tmp*=num[i+1];
                }
                else{
                    tmp/=num[i+1];
                }
            }
            max=Math.max(max,tmp);
            min=Math.min(min,tmp);
        }
        else{
            for(int i=0; i<n-1; i++){
                if(ch[i]==0){
                    pm[L]=arr[i];
                    ch[i]=1;
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n= Integer.parseInt(br.readLine());
        num = new int[n];
        arr = new int[n-1];
        pm = new int[n-1];
        ch = new int[n-1];
        // 피연산자 숫자들
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n-1; i++)    arr[i]=i;

        // 연산자 개수
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            int tmp = Integer.parseInt(st.nextToken());

            if(i==0){
                for(int j=0; j<tmp; j++){
                    list.add('+');
                }
            }
            else if(i==1){
                for(int j=0; j<tmp; j++){
                    list.add('-');
                }
            }
            else if(i==2){
                for(int j=0; j<tmp; j++){
                    list.add('*');
                }
            }
            else {
                for(int j=0; j<tmp; j++){
                    list.add('/');
                }
            }
        }

        DFS(0);

        System.out.println(max);
        System.out.println(min);

    }
}
