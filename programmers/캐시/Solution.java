import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0)    return cities.length * 5;
        List<String> cache = new ArrayList<>();
        for(String city : cities){
            city = city.toLowerCase();
            if(cache.contains(city)){
                answer+=1;
                //캐시 갱신
                cache.remove(city);
                cache.add(city);
            }
            else{
                //캐시에 없고 캐시가 꽉 차 있으면
                if(cacheSize==cache.size()){
                    cache.remove(0);
                }

                cache.add(city);
                answer+=5;
            }

        }
        return answer;
    }
}