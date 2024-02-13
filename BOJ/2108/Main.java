import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb  =new StringBuilder();

        int sum = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum+=arr[i];
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        double tmp = (double)sum / N;
        int avg = (int)Math.round(tmp);
        sb.append(avg).append("\n");

        Arrays.sort(arr);
        sb.append(arr[N/2]).append("\n");

        int maxCnt = 0;
        for(int i=0; i<N; i++){
            if(map.get(arr[i])>maxCnt)  maxCnt=map.get(arr[i]);
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            if(map.get(arr[i])==maxCnt) set.add(arr[i]);
        }

        List<Integer> list = set.stream().sorted().collect(Collectors.toList());

        if(set.size()==1)   sb.append(list.get(0)).append("\n");
        else if(set.size()>=2)  sb.append(list.get(1)).append("\n");

        sb.append(arr[arr.length-1]-arr[0]).append("\n");

        System.out.println(sb);




    }
}
