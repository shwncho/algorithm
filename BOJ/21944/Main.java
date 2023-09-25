import java.util.*;
import java.io.*;
class Problem implements Comparable<Problem>{

    public int problemNumber, level, category;
    Problem(int problemNumber, int level, int category){
        this.problemNumber = problemNumber;
        this.level = level;
        this.category = category;
    }

    @Override
    public int compareTo(Problem p){
        if(this.level == p.level)   return this.problemNumber - p.problemNumber;
        else return this.level - p.level;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());


        //전체 문제 난이도 정렬
        TreeSet<Problem> ts = new TreeSet<>();

        //알고리즘 그룹에 따른 난이도 정렬
        Map<Integer, TreeSet<Problem>> algoTreeSet = new HashMap<>();

        //문제번호 vs level
        Map<Integer, Integer> levelMap = new HashMap<>();
        //문제번호 vs 알고리즘 분류
        Map<Integer, Integer> categoryMap = new HashMap<>();


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            ts.add(new Problem(P,L,G));
            if(algoTreeSet.containsKey(G)){
                TreeSet<Problem> tmp = algoTreeSet.get(G);
                tmp.add(new Problem(P,L,G));
                algoTreeSet.replace(G,tmp);
            }
            else{
                TreeSet<Problem> tmp = new TreeSet<>();
                tmp.add(new Problem(P,L,G));
                algoTreeSet.put(G, tmp);
            }

            levelMap.put(P,L);
            categoryMap.put(P,G);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int n;

            if(str.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                ts.add(new Problem(P,L,G));
                if(algoTreeSet.containsKey(G)){
                    TreeSet<Problem> tmp = algoTreeSet.get(G);
                    tmp.add(new Problem(P,L,G));
                    algoTreeSet.replace(G,tmp);
                }
                else{
                    TreeSet<Problem> tmp = new TreeSet<>();
                    tmp.add(new Problem(P,L,G));
                    algoTreeSet.put(G, tmp);
                }
                levelMap.put(P,L);
                categoryMap.put(P,G);

            }
            else if(str.equals("recommend")){
                int G = Integer.parseInt(st.nextToken());
                String x = st.nextToken();
                if(x.equals("1")){
                    n = algoTreeSet.get(G).last().problemNumber;
                }
                else n = algoTreeSet.get(G).first().problemNumber;

                sb.append(n).append("\n");
            }
            else if(str.equals("recommend2")){
                String x = st.nextToken();
                if(x.equals("1")){
                    n = ts.last().problemNumber;
                }
                else n = ts.first().problemNumber;

                sb.append(n).append("\n");
            }
            else if(str.equals("recommend3")){
                String x = st.nextToken();
                int L = Integer.parseInt(st.nextToken());

                if(x.equals("1")){
                    Problem p =ts.ceiling(new Problem(0,L,0));
                    if(p==null){
                        sb.append("-1").append("\n");
                    }
                    else sb.append(p.problemNumber).append("\n");
                }

                else{
                    Problem p = ts.floor(new Problem(0,L,0));
                    if(p == null)   sb.append("-1").append("\n");
                    else sb.append(p.problemNumber).append("\n");
                }
            }
            //solved
            else{
                int P = Integer.parseInt(st.nextToken());
                int L = levelMap.get(P);
                int G = categoryMap.get(P);
                ts.remove(new Problem(P,L,G));
                algoTreeSet.get(G).remove(new Problem(P,L,G));
                levelMap.remove(P);
                categoryMap.remove(P);
            }
        }

        System.out.println(sb);

    }
}
