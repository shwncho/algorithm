import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        String s;
        //Array List -> HashSet으로 바꿔줬는데  통과됐다.
        //순서 x, 중복 x 일 때는 HashSet으 구현하자
        HashSet<String> hs= new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            hs.add(br.readLine());
        }


        for(int j=0; j<m; j++){
            s= br.readLine();
            if(hs.contains(s))    result.add(s);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(String x:result){
            System.out.println(x);
        }

    }
}
