import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class Main {
    public static int solution(int n, int m, int[] arr){
        int answer=0;
        Queue<Person> qu = new LinkedList<>();
        for(int i=0; i<n; i++){
            qu.add(new Person(i,arr[i]));
        }
        while(!qu.isEmpty()){
            Person tmp = qu.poll();
            for(Person x:qu){
                if(x.priority>tmp.priority){
                    qu.add(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if(tmp.id==m)   return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(solution(n,m,arr));
    }
}
