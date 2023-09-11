import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int L = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<L; i++)  list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);
        int n = Integer.parseInt(br.readLine());


        int idx = 0;
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)< n && n<list.get(i+1))   idx = i;
        }

        int cnt = 0;

        if(n<list.get(0)){
            for(int i=1; i<list.get(0); i++){
                for(int j=i+1; j<list.get(0); j++){
                    if(i<=n && n<=j)    cnt++;
                }
            }
        }
        else{
            for(int i=list.get(idx)+1; i<list.get(idx+1); i++){
                for(int j=i+1; j<list.get(idx+1); j++){
                    if(i<=n && n<=j)    cnt++;
                }
            }
        }


        System.out.println(cnt);


    }
}
