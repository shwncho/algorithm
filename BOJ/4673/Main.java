public class Main {
    public static void main(String[] args){
        boolean[] arr = new boolean[10001];

        for(int i=1; i<=10000; i++){
            int result = solution(i);
            if(result<=10000)   arr[result]=true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++){
            if(!arr[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
    public static int solution(int n){
        int sum = n;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}
