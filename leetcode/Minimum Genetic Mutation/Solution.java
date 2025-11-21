class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(Arrays.asList(bank).indexOf(endGene)==-1)    return -1;

        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        Set<String> visited = new HashSet<>();
        for(String b : bank)    visited.add(b);
        int answer = 0;
        while(!q.isEmpty()) {

            int size=  q.size();
            for(int k=0; k<size; k++){
                String now = q.poll();

                if(now.equals(endGene))   return answer;

                for(String b : bank) {
                    char[] nowChars = now.toCharArray();
                    char[] bChars = b.toCharArray();
                    int diff = 0;
                    if(!visited.contains(b))    continue;
                    for(int i=0; i<8; i++)  if(nowChars[i] != bChars[i])    diff++;

                    if(diff==1){
                        q.offer(b);
                        visited.remove(b);
                    }
                }
            }

            answer++;
        }

        return -1;
    }
}