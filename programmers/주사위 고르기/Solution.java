import java.util.*;
class Solution {
    static int n;
    static int[] combi,arr;
    static List<Integer> sumA,sumB;
    static int[] answer;
    static int max = Integer.MIN_VALUE;
    public int[] solution(int[][] dice) {
        answer = new int[n/2];

        n = dice.length;

        combi = new int[n/2];
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        selectDice(0,0,dice);


        return answer;
    }
    private void selectDice(int s, int L, int[][] dice){
        if(L==n/2){
            int[][] diceA = new int[n/2][6];
            sumA = new ArrayList<>();
            int[][] diceB = new int[n/2][6];
            sumB = new ArrayList<>();

            boolean[] ch = new boolean[n];
            for(int i=0; i<n/2; i++){
                ch[combi[i]-1]=true;
            }

            int idxA = 0;
            int idxB = 0;
            for(int i=0; i<n; i++){
                if(ch[i]){
                    diceA[idxA++]=dice[i];
                }
                else    diceB[idxB++]=dice[i];
            }

            sum(0,0,diceA,true);
            sum(0,0,diceB,false);

            Collections.sort(sumA);
            Collections.sort(sumB);

            int win = 0;
            for(int i=0; i<sumA.size(); i++){
                int left = 0;
                int right = sumB.size();
                while(left < right){
                    int mid = (left + right) / 2;
                    if(sumB.get(mid) < sumA.get(i)) left=mid+1;
                    else    right=mid;
                }
                win+=left;
            }
            if(win > max){
                answer = Arrays.copyOf(combi,n/2);
                max = win;
            }


            return;
        }

        for(int i=s; i<n; i++){
            combi[L]=arr[i];
            selectDice(i+1, L+1,dice);
        }

    }

    private void sum(int L, int result, int[][] dice, boolean isA){
        if(L==n/2){
            if(isA){
                sumA.add(result);
            }
            else    sumB.add(result);
            return;
        }

        for(int i=0; i<6; i++){
            sum(L+1,result+ dice[L][i],dice,isA);
        }
    }
}