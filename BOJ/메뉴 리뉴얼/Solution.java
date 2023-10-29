import java.util.*;
class Solution {
    static HashMap<String, Integer> map;
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for(int i=0; i<orders.length; i++){
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i]=String.valueOf(chars);
        }

        for(int i=0; i<course.length; i++){
            map = new HashMap<>();
            for(int j=0; j<orders.length; j++){
                StringBuilder sb = new StringBuilder();

                if(course[i] <=orders[j].length()){
                    combi(orders[j], sb, 0,0,course[i]);
                }

            }

            int max = Integer.MIN_VALUE;
            for(int x : map.values()){
                max=Math.max(max, x);
            }


            for(String s : map.keySet()){
                if(max>=2 && map.get(s)==max){
                    answer.add(s);
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static void combi(String str, StringBuilder sb, int idx, int cnt, int n){
        if(cnt==n){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }
        else{
            for(int i=idx; i<str.length(); i++){
                sb.append(str.charAt(i));
                combi(str,sb,i+1,cnt+1,n);
                sb.delete(cnt,cnt+1);
            }
        }
    }
}