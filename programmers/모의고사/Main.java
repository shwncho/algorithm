class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        int max = Integer.MIN_VALUE;

        for(int i=0; i<answers.length; i++){
            if(answers[i]==arr1[i%5])    cnt1++;

            if(answers[i]==arr2[i%8])    cnt2++;

            if(answers[i]==arr3[i%10])   cnt3++;
        }

        int tmp = Math.max(cnt1,Math.max(cnt2,cnt3));

        max = Math.max(max,tmp);

        int len=0;
        if(max==cnt1)   len++;
        if(max==cnt2)   len++;
        if(max==cnt3)   len++;

        answer=new int[len];
        int idx=0;
        if(max==cnt1)   answer[idx++]=1;
        if(max==cnt2)   answer[idx++]=2;
        if(max==cnt3)   answer[idx++]=3;
        return answer;
    }
}