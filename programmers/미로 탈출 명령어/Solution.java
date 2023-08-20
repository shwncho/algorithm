class Solution {
    static int graphX,graphY, endX, endY;
    // d,l,r,u 순서로 탐색
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String[] terms = {"d","l","r","u"};
    static String result = "";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        graphX = n;
        graphY = m;
        endX = r-1;
        endY = c-1;

        if(DFS(x-1,y-1,k,distance(x-1,y-1),"")){
            answer = result;
        }
        else    answer = "impossible";


        return answer;
    }
    public static boolean DFS(int x, int y, int k, int diff, String str){
        if(k == 0 && diff == 0){
            result = str;
            return true;
        }
        else{
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<graphX && ny>=0 && ny<graphY && diff<=k){
                    if(condition(k,diff)){
                        //발견하고 더 이상 반복문 탐색을 종료하기위해
                        if(DFS(nx,ny,k-1,distance(nx,ny),str+terms[i])){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean condition(int k, int diff){
        return (diff%2==0 && k%2==0) || (diff%2==1 && k%2==1);
    }

    public static int distance(int nx, int ny){
        return Math.abs(endX-nx) + Math.abs(endY-ny);
    }
}