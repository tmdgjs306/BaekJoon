import java.util.Scanner;

public class C_Coprime {
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        int T = sc.nextInt();
        for(int t = 0; t < T; t++)
        {
            int n = sc.nextInt();
            int [] array = new int[n+1];
            for(int i=1; i<=n; i++)
            {
                array[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            for(int i=n; i>0; i--)
            {
                for(int j=n; j>0; j--)
                {
                    if(gcd(array[i],array[j])==1)
                    {
                        max=Math.max(max,i+j);
                    }
                }
            }
            if(max!=Integer.MIN_VALUE)
            {
                sb.append(max).append("\n");
            }
            else
            {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
