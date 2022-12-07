import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num=0;
        int N;
        while(sc.hasNextInt()){
            N = sc.nextInt();
            for(int i=1;; i++){
                //((3*3+2) * 10 +1)%3 == ((3+2)*10+1)%3
                //어차피 (3*10)%3 ==0이다 그러므로 (3+2)만 남아도 나머지 값에 지장 없음
                num=num*10+1;
                num%=N;
                if(num==0){
                    System.out.println(i);
                    break;
                }

            }
        }



    }
}
