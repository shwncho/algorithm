import java.io.*;
import java.util.*;

class Person implements Comparable<Person>{

    int paperScore,interviewScore;
    Person(int paperScore, int interviewScore){
        this.paperScore = paperScore;
        this.interviewScore = interviewScore;
    }

    @Override
    public int compareTo(Person p){
        return this.paperScore - p.paperScore;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());

            ArrayList<Person> p = new ArrayList<>();
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());

                int ps = Integer.parseInt(st.nextToken());
                int is = Integer.parseInt(st.nextToken());

                p.add(new Person(ps,is));

            }

            Collections.sort(p);

            int std = p.get(0).interviewScore;
            int cnt = 1;
            for(Person tmp : p){
                if(tmp.interviewScore < std){
                    cnt++;
                    std = tmp.interviewScore;
                }
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb);
    }
}
