import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for(int i=0; i<n; i++){
            str[i]=br.readLine();
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);    //사전순 정렬
                }
                else{
                    return o1.length() - o2.length();   //길이 비교
                }
            }
        });

        System.out.println(str[0]);

        for(int i=1; i<n; i++) {
            //중복되지 않은 단어만 출력하기위해
            if (!str[i].equals(str[i - 1])) {
                System.out.println(str[i]);
            }
        }
    }
}
