import java.util.*;
class Solution {

    static class Node implements Comparable<Node> {
        public int x,y,a;

        Node(int x, int y, int a){
            this.x = x;
            this.y = y;
            this.a = a;
        }

        @Override
        public int compareTo(Node o){
            if(this.x == o.x && this.y != o.y)  return this.y - o.y;
            if(this.x == o.x && this.y == o.y)  return this.a - o.a;
            return this.x - o.x;
        }

        @Override
        public boolean equals(Object o){
            Node n = (Node)o;
            return (this.x == n.x) && (this.y == n.y) && (this.a == n.a);
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y,a);
        }
    }
    //기둥 셋
    static Set<Node> set1;
    //보 셋
    static Set<Node> set2;
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        List<Node> result = new ArrayList<>();
        for(int[] command : build_frame){

            List<Node> copyResult = copy(result, command[0],command[1],command[2],command[3]);
            //기둥인지 보인지 확인
            if(command[2]==0){

                //설치인지 삭제인지
                if(command[3]==0){
                    if(check(copyResult)){
                        for(int i=0; i<result.size(); i++){
                            if(command[0]==result.get(i).x && command[1] == result.get(i).y && command[2] == result.get(i).a){
                                result.remove(i);
                                break;
                            }
                        }
                    }
                }
                //설치
                else{
                    if(check(copyResult)){
                        result.add(new Node(command[0], command[1], command[2]));
                    }
                }
            }
            //보
            else{
                //설치인지 삭제인지
                if(command[3]==0){
                    if(check(copyResult)){
                        for(int i=0; i<result.size(); i++){
                            if(command[0]==result.get(i).x && command[1] == result.get(i).y && command[2] == result.get(i).a){
                                result.remove(i);
                                break;
                            }
                        }
                    }
                }
                //설치
                else{
                    if(check(copyResult)){
                        result.add(new Node(command[0], command[1], command[2]));
                    }
                }
            }
        }

        Collections.sort(result);
        answer = new int[result.size()][3];

        for(int i=0; i<result.size(); i++){
            Node tmp = result.get(i);
            answer[i] = new int[]{tmp.x, tmp.y, tmp.a} ;

        }
        return answer;
    }

    private List<Node> copy(List<Node> list, int x, int y, int a, int b){
        List<Node> res = new ArrayList<>();

        if(b==0){
            for(Node tmp : list){
                if(tmp.x == x && tmp.y == y && tmp.a == a)  continue;
                res.add(tmp);
            }
        }
        else{
            for(Node tmp : list)    res.add(tmp);
            res.add(new Node(x,y,a));

        }
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        for(Node n : res){
            if(n.a==0)  set1.add(new Node(n.x,n.y,n.a));
            else    set2.add(new Node(n.x,n.y,n.a));
        }
        return res;
    }
    private boolean check(List<Node> list){

        for(Node n : list){
            if(n.a==0){
                //기둥이 바닥 위
                if(n.y==0)  continue;
                    //기둥이 보의 한 쪽 끝 부분 위
                else if(set2.contains(new Node(n.x-1,n.y,1)) || set2.contains(new Node(n.x,n.y,1)))  continue;

                    //기둥은 또 다른 기둥 위
                else if(set1.contains(new Node(n.x,n.y-1,0)))    continue;

                else return false;
            }

            else{
                //보의 한 쪽 끝부분이 기둥
                if(set1.contains(new Node(n.x,n.y-1,0)) || set1.contains(new Node(n.x+1,n.y-1,0))){
                    continue;
                }

                //보의 양쪽 끝 부분이 다른 보와 동시에 연결
                else if(set2.contains(new Node(n.x+1,n.y,1)) && set2.contains(new Node(n.x-1,n.y,1)))    continue;

                else return false;
            }
        }


        return true;
    }
}