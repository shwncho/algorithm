import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;

        //날짜 계산 함수 알아보기 , int[] answer에 어떻게 담아서 return 할지도알아보기

        //일자 계산
        String[] todaySplit = today.split("[.]");

        int todayYear = Integer.parseInt(todaySplit[0]);
        int todayMonth = Integer.parseInt(todaySplit[1]);
        int todayDay = Integer.parseInt(todaySplit[2]);

        int todaySum = ((todayYear - 2000)*28*12)+ ((todayMonth - 1) * 28) + (todayDay - 1);

        Map<String, Integer> termMap = new HashMap<>();
        for(String s : terms){
            String[] str = s.split(" ");
            termMap.put(str[0], Integer.parseInt(str[1])*28);
        }

        ArrayList<Integer> answers = new ArrayList<>();

        int idx = 1;
        for(String s : privacies){
            String[] str = s.split(" ");
            String targetDate = str[0];
            String targetTerm = str[1];

            String[] target = targetDate.split("[.]");

            int targetYear = Integer.parseInt(target[0]);
            int targetMonth = Integer.parseInt(target[1]);
            int targetDay = Integer.parseInt(target[2]);

            int targetSum = ((targetYear - 2000)*28*12)+ ((targetMonth - 1) * 28) + (targetDay - 1);


            if(todaySum - targetSum >= termMap.get(targetTerm)){
                answers.add(idx);
            }
            idx++;

        }
        answer = new int[answers.size()];
        for(int i=0; i<answers.size(); i++){
            answer[i] = answers.get(i);
        }
        return answer;
    }





}