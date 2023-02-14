import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        //소문자, 대문자, 숫자, 공백
        while((str=br.readLine())!=null){
            char[] arr = str.toCharArray();
            int[] answer = new int[4];


            for(int i=0; i<arr.length; i++){
                if(Character.isLowerCase(arr[i])){
                    answer[0]++;
                }
                else if(Character.isUpperCase(arr[i])){
                    answer[1]++;
                }
                else if('0'<=arr[i] && arr[i]<='9'){
                    answer[2]++;
                }
                else    answer[3]++;
            }

            for(int x :answer){
                sb.append(x+" ");
            }
            sb.append("\n");

        }

        System.out.println(sb);
    }
}