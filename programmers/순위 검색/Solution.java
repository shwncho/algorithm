import java.util.*;
class Solution {
    static Map<String,ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        for(int i=0; i<info.length; i++){
            DFS("",info[i].split(" "),0);
        }

        //정렬을 여기서 하는 것과 이분 탐색 안에서 정렬하는 것은 시간복잡도가 달라짐
        for(ArrayList<Integer> list : map.values()) Collections.sort(list);

        answer = new int[query.length];
        for(int i=0; i<query.length; i++){
            answer[i]=binarySearch(query[i]);
        }

        return answer;
    }

    static void DFS(String str, String[] info, int idx){
        if(idx==4){
            if(map.containsKey(str)){
                map.get(str).add(Integer.parseInt(info[4]));
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(str, list);
            }
        }
        else{
            DFS(str+info[idx],info,idx+1);
            DFS(str+"-",info,idx+1);
        }
    }

    static int binarySearch(String query){
        String[] str = query.split(" and ");
        int score = Integer.parseInt(str[3].split(" ")[1]);

        String tmp = str[0] + str[1] + str[2] + str[3].split(" ")[0];

        if(!map.containsKey(tmp))   return 0;

        ArrayList<Integer> list = map.get(tmp);

        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid)<score)    left=mid+1;
            else    right=mid;
        }

        return list.size() - left;
    }
}