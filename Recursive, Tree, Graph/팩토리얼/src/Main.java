public class Main {
    public static int DFS(int n){
        if(n==1)    return 1;

        return n*DFS(n-1);
    }
    public static void main(String[] args) {
        System.out.println(DFS(5));
    }
}
