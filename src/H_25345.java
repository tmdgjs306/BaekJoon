import java.util.Scanner;

public class H_25345 {
    static long fn=1,fk=1,fnk=1;
    static int N,K;
    static int div =1000000007;
    static void dp() {
        long f = 1;
        for(int i=1; i<=N; i++) {
            f = (f*i)%div;
            if(i==N) fn = f;
            if(i==N-K) fnk = f;
            if(i==K) fk=f;
        }
    }
    static long calc(long n,int parent) {
        if(parent==0) return 1;
        long tmp = calc(n,parent/2);
        long result = tmp*tmp%div;
        if(parent%2==0) return result;
        else return (result*n)%div;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int [] list =new int[N];
        dp();
        long temp =(fk*fnk)%div;
        long value = calc(temp,div-2)%div;
        long ans = (fn*value)%div;

        for(int i=0; i<N; i++)
        {
            list[i] = sc.nextInt();
        }

        if(K==1)
        {
            System.out.println(N);
            return;
        }
        for(int i=1; i<K; i++)
        {
            ans*=2;
            ans%=div;
        }
        System.out.println((ans)%div);
    }
}
