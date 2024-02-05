import java.util.*;
class Solution {
    static class Job implements Comparable<Job>{
        public int s,p;
        Job(int s, int p){
            this.s=s;
            this.p=p;
        }

        @Override
        public int compareTo(Job o){
            return this.p - o.p;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;

        Arrays.sort(jobs, (j1,j2) -> j1[0]-j2[0]);
        Queue<Job> pQ = new PriorityQueue<>();

        //처리한 작업의 개수
        int count = 0;
        //현재 기준 시간
        int current = 0;
        //인덱스
        int idx = 0;

        while(count < len){

            while(idx < len && jobs[idx][0]<=current){
                Job job = new Job(jobs[idx][0],jobs[idx][1]);
                idx++;
                pQ.offer(job);
            }

            if(pQ.isEmpty()){
                current = jobs[idx][0];
            }
            else{
                Job cur = pQ.poll();
                answer+=current - cur.s + cur.p;
                current+=cur.p;
                count++;
            }
        }


        return answer / len;
    }
}