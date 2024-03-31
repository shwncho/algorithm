import java.util.*;
class Solution {
    static Set<String> set = new HashSet<>();
    static int[] checked;
    public int solution(String[][] relation) {
        int answer = 0;
        //풀이 로직

        //컬럼 선택 길이 1~n에 따른 DFS 진행
        //DFS에 필요한 것 -> depth(=후보키의 컬럼 개수)

        //검증 로직 1. 최소성 만족 2. 유일성 만족

        //최소성 만족
        //정답으로 사용할 셋에 현재 후보키조합이 포함되어 있는지

        //유일성 만족
        //탐색할 후보키 컬럼 정하고
        //테이블에 후보키의 튜플이 같은 로우가 있는지 확인


        for(int i=1; i<=relation[0].length; i++){
            checked = new int[i];
            DFS(0,0,i,relation);
        }


        answer = set.size();
        return answer;
    }
    private void DFS(int L, int s, int depth, String[][] relation){
        if(L==depth){
            //선택된 컬럼 문자열로 생성
            String target ="";
            for(int i=0; i<checked.length; i++){
                target+=checked[i];
            }
            //후보키 문자열을 검증
            if(isValid(target,relation)){
                set.add(target);
            }

        }
        else{
            for(int i=s; i<relation[0].length; i++){
                checked[L]=i;
                DFS(L+1,i+1,depth,relation);
            }
        }
    }

    private boolean isValid(String target, String[][] relation){
        //최소성 만족
        for(String s : set){
            boolean flag = true;
            for(int i=0; i<s.length(); i++){
                if(!target.contains(s.charAt(i)+""))    flag=false;
            }

            if(flag)    return false;
        }

        //유일성 만족
        String[] str = new String[relation.length];
        for(int i=0; i<relation.length; i++)    str[i]="";
        Set<String> unique = new HashSet<>();
        for(int i=0; i<target.length(); i++){
            int idx = Integer.parseInt(target.substring(i,i+1));

            for(int j=0; j<relation.length; j++){
                str[j]+=relation[j][idx];
            }
        }

        for(int i=0; i<str.length; i++){
            if(unique.contains(str[i])){
                return false;
            }
            unique.add(str[i]);
        }


        return true;
    }
}