import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);


            if(ch=='c') {
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='=' || s.charAt(i+1)=='-'){
                        i++;
                    }
                }
            }

            else if(ch=='d'){
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='z'){
                        if(i<s.length()-2){
                            if(s.charAt(i+2)=='='){
                                i=i+2;
                            }
                        }
                    }
                    else if(s.charAt(i+1)=='-'){
                        i++;
                    }
                }
            }

            else if(ch=='l'){
                if(i<s.length()-1){
                    if (s.charAt(i+1) == 'j') {
                        i++;
                    }
                }
            }
            else if(ch=='n'){
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='j'){
                        i++;
                    }
                }
            }

            else if(ch=='s'){
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='='){
                        i++;
                    }
                }
            }

            else if(ch=='z'){
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='='){
                        i++;
                    }
                }
            }

            cnt++;


        }

        System.out.println(cnt);


    }
}
