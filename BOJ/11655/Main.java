import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i++){
            if(Character.isAlphabetic(arr[i])){
                char c = arr[i];

                if(Character.isLowerCase(c)){
                    if((c+13)>122){
                        arr[i]=(char)(c-13);
                    }
                    else    arr[i]=(char)(c+13);
                }

                else if(Character.isUpperCase(c)){
                    if((c+13)>90){
                        arr[i]=(char)(c-13);
                    }
                    else    arr[i]=(char)(c+13);
                }

            }
        }


        for(char c : arr){
            System.out.print(c);
        }
    }
}