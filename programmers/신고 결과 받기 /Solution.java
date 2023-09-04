import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        StringTokenizer st;

        //유저별 신고당한 횟수
        Map<String,Integer> userByReported = new HashMap<>();

        //유저ID와 신고한 ID
        Map<String, ArrayList<String>> userReportOtherUser = new HashMap<>();

        //유저ID와 메일 받은 횟수(신고한 ID를 신고당한 횟수 get 한 뒤 k이상이면 count
        Map<String, Integer> result = new HashMap<>();


        for(int i=0; i<id_list.length; i++){
            userByReported.put(id_list[i],0);
        }

        for(int i=0; i<id_list.length; i++){
            userReportOtherUser.put(id_list[i], new ArrayList<>());
        }

        for(int i=0; i<report.length; i++){
            st = new StringTokenizer(report[i]);
            String userId = st.nextToken();
            String reportId = st.nextToken();

            ArrayList<String> list = userReportOtherUser.get(userId);
            if(!list.contains(reportId)){
                list.add(reportId);
            }


        }

        //유저별 신고당한 횟수 카운팅
        for(int i=0; i<userReportOtherUser.size(); i++){
            ArrayList<String> list = userReportOtherUser.get(id_list[i]);
            for(int j=0; j<list.size(); j++){
                String reportId = list.get(j);
                userByReported.put(reportId,userByReported.getOrDefault(reportId,0)+1);
            }

        }


        for(int i=0; i<id_list.length; i++){
            int cnt = 0;
            ArrayList<String> list = userReportOtherUser.get(id_list[i]);
            for(String s : list){
                if(userByReported.get(s)>=k)    cnt++;
            }
            result.put(id_list[i],cnt);
        }


        for(int i=0; i<id_list.length; i++){
            answer[i] = result.get(id_list[i]);
        }




        return answer;
    }
}