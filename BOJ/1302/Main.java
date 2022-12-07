import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String s = br.readLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }

        String str=map.entrySet()
                .stream()
                .max(
                (entry1,entry2) -> {
                    if(entry1.getValue() > entry2.getValue()){
                        return 1;
                    }
                    else if(entry1.getValue() == entry2.getValue()){
                        return entry1.getKey().compareTo(entry2.getKey())*(-1);
                    }
                    return -1;
                })
                .get().getKey();

        System.out.println(str);



    }
}
