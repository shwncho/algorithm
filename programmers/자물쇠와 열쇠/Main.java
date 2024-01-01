class Solution {
    public boolean solution(int[][] key, int[][] lock) {

        int M = key.length;
        int N = lock.length;

        int size = N+M*2-2;
        int[][] map = new int[size][size];

        for(int i=M-1; i<M+N-1; i++){
            for(int j=M-1; j<M+N-1; j++){
                map[i][j] = lock[i-(M-1)][j-(M-1)];
            }
        }

        for(int i=0; i<4; i++){
            if(check(map,key,N)){
                return true;
            }
            rotate(key);
        }

        return false;
    }

    private static boolean check(int[][] map, int[][] key, int lockLen){
        int keyLen = key.length;
        int mapLen = map.length;

        for(int i=0; i<mapLen-keyLen+1; i++){
            for(int j=0; j<mapLen-keyLen+1; j++){

                for(int k=0; k<keyLen; k++){
                    for(int l=0; l<keyLen; l++){
                        map[i+k][j+l] +=key[k][l];
                    }
                }

                boolean flag = true;
                for(int k=keyLen-1; k<keyLen+lockLen-1; k++){
                    for(int l=keyLen-1; l<keyLen+lockLen-1; l++){
                        if(map[k][l]!=1){
                            flag=false;
                            break;
                        }
                    }
                    if(!flag)   break;
                }
                if(flag)    return true;

                for(int k=0; k<keyLen; k++){
                    for(int l=0; l<keyLen; l++){
                        map[i+k][j+l]-=key[k][l];
                    }
                }
            }

        }
        return false;
    }

    private static void rotate(int[][] key){
        int len = key.length;
        int[][] tmp = new int[len][len];

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                tmp[j][len-1-i] = key[i][j];
            }
        }

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                key[i][j] = tmp[i][j];
            }
        }
    }


}