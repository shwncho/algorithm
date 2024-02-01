import java.util.*;
// 효율적인 풀이
class Solution {
    public int solution(int[] scoville, int K){
        Queue<Integer> pQ = new PriorityQueue<>();

        for(int value : scoville){
            pQ.offer(value);
        }

        //가장 낮은 수가 K 이상이 될 때까지, pQ에 1개의 원소만 남을 때까지 섞기
        int cnt = 0;
        while(pQ.size() > 1 && pQ.peek() < K){
            pQ.offer(pQ.poll() + (pQ.poll() * 2));
            cnt++;
        }

        return pQ.peek() >= K ? cnt : -1;
    }
}





// 원래 내 풀이
// class Solution {
//     public int solution(int[] scoville, int K) {
//         int answer = 0;

//         Queue<Integer> pQ = new PriorityQueue<>();
//         boolean flag = true;
//         for(int value : scoville){
//             if(value<K) flag=false;
//             pQ.offer(value);
//         }
//         //주어진 배열이 이미 전부 K 이상일 경우 0회
//         if(flag)    return 0;

//         int cnt=0;
//         while(true){

//             if(check(pQ,K)){
//                 cnt++;
//                 break;
//             } 

//             if(pQ.size()==1 && pQ.peek()<K){
//                 cnt = -1;
//                 break;
//             }
//             cnt++;
//         }
//         answer = cnt;
//         return answer;

//     }

//     private boolean check(Queue<Integer> pQ, int K){
//         int n1 = pQ.poll();
//         int n2 = pQ.poll();

//         pQ.offer(n1 + (n2 * 2));

//         for(int i=0; i<pQ.size(); i++){
//             int value = pQ.poll();
//             if(value<K){
//                 pQ.offer(value);
//                 return false;
//             }
//             else{
//                 pQ.offer(value);
//             }
//         }

//         return true;
//     }
//}