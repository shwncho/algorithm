public class Main {
    static int q,r,s,t,r1,s1,t1,r2,s2,t2;
    public static void solution(int a, int b){
        r1=a; r2=b;
        s1=1; s2=0;
        t1=0; t2=1;

        while(r2>0){

            q=r1/r2;
            r=r1-q*r2;

            r1=r2;
            r2=r;

            s =s1-q*s2;
            s1=s2;
            s2=s;

            t =t1-q*t2;
            t1=t2;
            t2=t;
        }
    }
    public static void main(String[] args) {
        solution(6,8);
        int c=3;
        System.out.println(c%r1==0 ? s1*(c/r1)+" "+t1*(c/r1)+" "+r1*c : -1);
        //s는 x의 값, t는 y의 값
    }
}
