import java.util.*;

public class Main {
    public static int[] solution(int s, int n, int[] arr){
        int[] answer=new int[s];
        for(int i=0; i<n; i++){
            int idx=-1; //이렇게 변수값의 변화를 이용하면 배열의 전체를 탐색할 수 있음
            for(int j=0; j<s; j++) {
                if (arr[i] == answer[j]) idx = j;
            }
            if(idx!=-1){
                for(int k=idx; k>0; k--){
                    answer[k]=answer[k-1];
                }
            }
            else{
                for(int k=s-1; k>0; k--){
                    answer[k]=answer[k-1];
                }
            }
            answer[0]=arr[i];

        }
        return answer;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s=sc.nextInt();
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        for(int x:solution(s,n,arr)){
            System.out.print(x+" ");
        }
    }
}
