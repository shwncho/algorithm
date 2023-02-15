import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] arr;
    //부분집합이므로 20개의 정수배열은 2^20개의 경우의 수가 나옴 그것이 2개 나올 수 있으므로 long
    static long cnt=0;
    static ArrayList<Integer> leftList = new ArrayList<>();
    static ArrayList<Integer> rightList = new ArrayList<>();
    static void DFS(int sum, int start, int end, ArrayList<Integer> list){
        if(start==end){
            list.add(sum);
        }
        else{
            DFS(sum+arr[start], start+1, end, list);
            DFS(sum, start+1, end, list);
        }
    }

    static void solution(){
        int leftIndex = 0;
        int rightIndex = rightList.size()-1;


        while(leftIndex < leftList.size() && rightIndex>=0){

            int leftValue = leftList.get(leftIndex);
            int rightValue = rightList.get(rightIndex);

            if(leftValue + rightValue < m) leftIndex++;

            if(leftValue + rightValue >m) rightIndex--;

            if(leftValue + rightValue == m) {
                //leftCount * rightCount 경우의 수가 int 범위를 넘어설 수 있음
                long leftCount = 0;
                long rightCount = 0;

                //왼쪽 또는 오른쪽 리스트에 동일한 값이 여러개 있을 수 있으므로 카운팅
                while (leftIndex < leftList.size() && leftList.get(leftIndex) == leftValue) {
                    leftIndex++;
                    leftCount++;
                }

                while (rightIndex >= 0 && rightList.get(rightIndex) == rightValue) {
                    rightIndex--;
                    rightCount++;
                }

                cnt += leftCount * rightCount;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  arr[i]=Integer.parseInt(st.nextToken());

        DFS(0,0,n/2,leftList);
        DFS(0,n/2,n,rightList);

        Collections.sort(leftList);
        Collections.sort(rightList);

        solution();

        System.out.println(m==0 ? cnt-1 : cnt);



    }
}
