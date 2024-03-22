import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();

        ArrayList<String> result = new ArrayList<>();
        // 유저 고유 아이디의 최종 닉네임
        Map<String,String> userIdVsNickname = new HashMap<>();
        // 결과 리스트에 들어간 인덱스 별 유저 고유 아이디
        Map<Integer,String> idxVsUserId = new HashMap<>();


        int idx = 0;
        // 유저 고유 아이디 별 출입기록 or 닉네임 변경
        for(int i=0; i<record.length; i++){

            String[] str = record[i].split(" ");
            String action = str[0];

            if(action.equals("Enter")){
                String userId = str[1];
                String nickname = str[2];
                result.add(userId+"님이 들어왔습니다.");
                userIdVsNickname.put(userId, nickname);
                idxVsUserId.put(idx++,userId);
            }
            else if(action.equals("Leave")){
                String userId = str[1];
                result.add(userId+"님이 나갔습니다.");
                idxVsUserId.put(idx++,userId);
            }
            else{
                String userId = str[1];
                String nickname = str[2];
                userIdVsNickname.put(userId, nickname);
            }
        }

        for(int i=0; i<result.size(); i++){
            String userId = idxVsUserId.get(i);
            String nickname = userIdVsNickname.get(userId);
            answer.add(result.get(i).replace(userId,nickname));
        }


        return answer;
    }
}