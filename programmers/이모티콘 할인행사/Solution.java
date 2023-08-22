import java.util.*;
class Result implements Comparable<Result>{
    public int serviceNum, money;

    Result(int serviceNum, int money){
        this.serviceNum = serviceNum;
        this.money = money;
    }

    public int getServiceNum(){
        return this.serviceNum;
    }

    public int getMoney(){
        return this.money;
    }

    @Override
    public int compareTo(Result o){
        if(o.serviceNum == this.serviceNum) return o.money - this.money;
        return o.serviceNum - this.serviceNum;
    }
}
class Solution {
    static ArrayList<Integer> sales = new ArrayList<>();
    static ArrayList<Result> results = new ArrayList<>();
    static int[] arr;
    //할인 4가지 경우
    static int[] tmp = {10,20,30,40};
    public static void permutation(int L, int n, int[][] users, int[] emoticons){
        if(L==n){
            for(int i=0; i<n; i++){
                sales.add(arr[i]);
            }

            calculate(users, emoticons);
            sales = new ArrayList<>();
        }
        else{
            for(int i=0; i<4; i++){
                arr[L]=tmp[i];
                permutation(L+1,n,users,emoticons);
            }
        }
    }

    public static void calculate(int[][] users, int[] emoticons){

        int[] sum = new int[users.length];

        for(int i=0; i<users.length; i++){

            for(int j=0; j<sales.size(); j++){
                if(sales.get(j)>=users[i][0]){
                    sum[i] += emoticons[j] *(1-(sales.get(j)*0.01));
                }
            }

        }


        int num = 0;
        int total = 0;
        for(int i=0; i<users.length; i++){
            if(sum[i] < users[i][1]){
                total+=sum[i];
            }
            else{
                num++;
            }
        }

        results.add(new Result(num, total));
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        arr = new int[emoticons.length];

        permutation(0,emoticons.length,users,emoticons);

        Collections.sort(results);

        answer[0] = results.get(0).getServiceNum();
        answer[1] = results.get(0).getMoney();



        return answer;
    }
}