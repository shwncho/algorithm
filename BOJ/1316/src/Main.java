import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean check(String str){
        boolean[] check = new boolean[26];
        int prev=0;


        for(int i=0; i<str.length(); i++){

            int now = str.charAt(i);

            if(prev!=now){
                if(!check[now-'a']){
                    check[now-'a']=true;
                    prev=now;
                }
                else{
                    return false;
                }
            }


        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0; i<n; i++){
            if(check(br.readLine()))  cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();

        br.close();
        bw.close();

    }


}
