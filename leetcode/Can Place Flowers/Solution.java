class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowerCnt = 0;

        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i] == 0){
                if((i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)){
                    flowerCnt++;
                    flowerbed[i]=1;
                    if(flowerCnt>=n)  return true;
                }
            }
        }
        return flowerCnt >= n;
    }
}