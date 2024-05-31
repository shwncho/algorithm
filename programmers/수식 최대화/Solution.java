import java.util.*;
class Solution {

    private static long answer;
    private List<Long> expressionNums;
    private List<Character> expressionOps;
    private char[] ops;
    private char[] priorities;
    private boolean[] checked;
    public long solution(String expression) {

        answer = 0;
        expressionNums = new ArrayList<>();
        expressionOps = new ArrayList<>();

        ops = new char[]{'+','-','*'};
        priorities = new char[3];
        checked = new boolean[3];

        int numIdx = 0;

        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*'){
                expressionOps.add(ch);
                expressionNums.add(Long.parseLong(expression.substring(numIdx,i)));
                numIdx = i+1;
            }
        }
        expressionNums.add(Long.parseLong(expression.substring(numIdx)));

        DFS(0);

        return answer;
    }

    private void DFS(int L){
        if(L==3){
            answer = Math.max(answer, Math.abs(calculateExpression()));
            return;
        }

        for(int i=0; i<ops.length; i++){
            if(!checked[i]){
                priorities[L] = ops[i];
                checked[i]=true;
                DFS(L+1);
                checked[i]=false;
            }
        }
    }

    private long calculateExpression(){
        List<Long> tmpNums = new ArrayList<>(expressionNums);
        List<Character> tmpOps = new ArrayList<>(expressionOps);

        while(tmpOps.size()>0){
            int maxPriority=0;
            for(int i=0; i<tmpOps.size(); i++){
                maxPriority = Math.max(maxPriority,getPriority(tmpOps.get(i)));
            }
            for(int i=0; i<tmpOps.size(); i++){
                if(getPriority(tmpOps.get(i))==maxPriority){
                    tmpNums.add(i,
                            calculate(tmpNums.remove(i),
                                    tmpNums.remove(i),
                                    tmpOps.remove(i)));
                    //i번째를 remove했기 때문에 다시 i번째 부터 탐색
                    i--;
                }
            }
        }
        return tmpNums.get(0);
    }

    private long calculate(long num1, long num2, char op){
        if(op=='+') return num1 + num2;
        else if(op=='-')    return num1 - num2;
        else    return num1 * num2;
    }
    private int getPriority(char op){
        int priority;
        if(op==priorities[0])   priority=2;
        else if(op==priorities[1])  priority=1;
        else    priority=0;

        return priority;
    }
}