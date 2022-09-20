import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[][] player = new int[n][2];

        boolean flag;
        int answer=0;

        for(int i=0; i<n; i++){
            player[i][0]=sc.nextInt();
            player[i][1]=sc.nextInt();
        }

        for(int i=0; i<n; i++){
            flag=true;
            for(int j=0; j<n; j++){
                if(player[i][0]<player[j][0] && player[i][1]<player[j][1]){
                    flag=false;
                    break;
                }
            }
            if(flag)    answer++;
        }

        System.out.println(answer);

    }
}
