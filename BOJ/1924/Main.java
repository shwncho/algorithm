import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] months = {0, 31 ,28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        int result = 0;
        for(int i=0; i<month; i++){
            result +=months[i];
        }
        result+=day;
        System.out.println(dayOfWeek[result%7]);

    }
}
