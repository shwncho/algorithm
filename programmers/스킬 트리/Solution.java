class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer=0;
        for(String skillT : skill_trees){
            String tmp=skillT;
            for(int i=0; i<skillT.length(); i++){
                String s = skillT.substring(i,i+1);
                if(!skill.contains(s)){
                    tmp=tmp.replace(s,"");
                }
            }

            boolean flag = true;
            for(int j=0; j<tmp.length(); j++){
                if(!tmp.substring(j,j+1).equals(skill.substring(j,j+1))){
                    flag=false;
                    break;
                }
            }
            if(flag)  answer++;
        }
        return answer;
    }
}
