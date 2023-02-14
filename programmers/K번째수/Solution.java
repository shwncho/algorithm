import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int len=0;
        for(int[] tmp : commands){
            int i = tmp[0]-1;
            int j = tmp[1]-1;
            int k = tmp[2]-1;

            int[] slice = new int[j-i+1];
            int idx=0;
            for(int s=i; s<=j; s++){
                slice[idx++]=array[s];
            }

            Arrays.sort(slice);
            answer[len++]=slice[k];
        }
        return answer;
    }
}
