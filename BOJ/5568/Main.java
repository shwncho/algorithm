import java.util.*;
import java.io.*;
public class Main {
    static int n,k;
    static int[] arr;
    static String[] pm;
    static Set<Integer> set = new HashSet<>();
    static int[] checked;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        checked = new int[n];
        pm = new String[k];
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        permutation(0);

        System.out.println(set.size());

    }
    public static void permutation(int L){
        if(L==k){
            String num="";
            for(int i=0; i<k; i++){
                num+= pm[i];
            }
            set.add(Integer.parseInt(num));
        }
        else{
            for(int i=0; i<n; i++){
                if(checked[i]==0){
                    checked[i]=1;
                    pm[L]= String.valueOf(arr[i]);
                    permutation(L+1);
                    checked[i]=0;
                }
            }
        }
    }
}
