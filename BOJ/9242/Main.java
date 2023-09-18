import java.io.*;
import java.util.*;

public class Main{
    static int[][] number0 = {{1,1,1},{1,0,1},{1,0,1},{1,0,1},{1,1,1}};
    static int[][] number1 = {{0,0,1},{0,0,1},{0,0,1},{0,0,1},{0,0,1}};
    static int[][] number2 = {{1,1,1},{0,0,1},{1,1,1},{1,0,0},{1,1,1}};
    static int[][] number3 = {{1,1,1},{0,0,1},{1,1,1},{0,0,1},{1,1,1}};
    static int[][] number4 = {{1,0,1},{1,0,1},{1,1,1},{0,0,1},{0,0,1}};
    static int[][] number5 = {{1,1,1},{1,0,0},{1,1,1},{0,0,1},{1,1,1}};
    static int[][] number6 = {{1,1,1},{1,0,0},{1,1,1},{1,0,1},{1,1,1}};
    static int[][] number7 = {{1,1,1},{0,0,1},{0,0,1},{0,0,1},{0,0,1}};
    static int[][] number8 = {{1,1,1},{1,0,1},{1,1,1},{1,0,1},{1,1,1}};
    static int[][] number9 = {{1,1,1},{1,0,1},{1,1,1},{0,0,1},{1,1,1}};
    static int[][][] numbers = new int[10][5][3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = new String[5];

        numbers[0]=number0;
        numbers[1]=number1;
        numbers[2]=number2;
        numbers[3]=number3;
        numbers[4]=number4;
        numbers[5]=number5;
        numbers[6]=number6;
        numbers[7]=number7;
        numbers[8]=number8;
        numbers[9]=number9;

        for(int i=0; i<5; i++){
            input[i] = br.readLine();
        }

        System.out.println(solution(input));
    }

    public static String solution(String[] input){

        int[][] value = new int[5][3];
        String num = "";

        for(int i=0; i<input[0].length(); i=i+4){

            for(int j=0; j<5; j++){
                for(int k=i; k<i+3; k++){
                    if(k==input[0].length())    break;
                    String tmp = input[j];
                    String s = tmp.substring(k,k+1);

                    if(s.equals("*"))    value[j][k%4] = 1;
                    else    value[j][k%4] = 0;
                }
            }

            boolean isValid = false;
            for(int j=0; j<10; j++){
                int[][] n = numbers[j];
                boolean flag = true;
                for(int k=0; k<5; k++){
                    for(int s=0; s<3; s++){
                        if(n[k][s]!=value[k][s]){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    isValid=true;
                    num+=String.valueOf(j);
                }
            }
            if(!isValid)    return "BOOM!!";
        }


        int result = Integer.parseInt(num);
        if(result%6==0)    return "BEER!!";
        else    return "BOOM!!";

    }
}