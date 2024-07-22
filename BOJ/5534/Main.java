import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        char[] name = br.readLine().toCharArray();

        for(int i=0; i<N; i++){
            char[] tmp = br.readLine().toCharArray();

            answer+=solution(tmp,name);

        }

        System.out.println(answer);
    }
    private static int solution(char[] target, char[] name){
        for(int i=0; i< target.length; i++){
            if(target[i] == name[0]){
                for(int j=i; j<target.length; j++){
                    if(target[j]==name[name.length-1]){
                        int gap = (j - i) / (name.length-1);
                        int cnt=0;
                        while(cnt<name.length){
                            if(target[i+gap*cnt]==name[cnt]){
                                cnt++;
                                continue;
                            }
                            break;
                        }
                        if(cnt==name.length)    return 1;
                    }
                }
            }
        }
        return 0;
    }
}
