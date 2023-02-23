import java.util.*;
class Word{
    public String s;
    public int n;

    Word(String s, int n){
        this.s=s;
        this.n=n;
    }
}
class Solution {
    public static boolean check(String s1, String s2){
        int cnt=0;

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i))  cnt++;
        }

        if(cnt==1)  return true;
        else    return false;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];

        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        while(!q.isEmpty()){

            for(int k=0; k<q.size(); k++){
                String s = q.poll();

                if(s.equals(target))    return answer;

                for(int i=0; i<words.length; i++){
                    if(check(s,words[i]) && !visited[i]){
                        q.offer(words[i]);
                        visited[i]=true;
                    }
                }

            }
            answer++;

        }


        return 0;
    }

}