class Solution {
    public long solution(int w, int h) {
        long wl = w;
        long hl = h;

        return (wl*hl)-(wl+hl-gcd(wl,hl));
    }

    //최대공약수 떠올리는게 핵심
    public static long gcd(long a, long b){
        if(b==0)    return a;
        return gcd(b,a%b);
    }
}
