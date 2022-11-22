import java.util.Scanner;

public class C_B {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        int t = sc.nextInt();
        for(int T=0; T<t; T++) {
            int n = sc.nextInt();
            if(n==3)
            {
                sb.append("-1");
                sb.append("\n");
                continue;
            }
            if(n==5)
            {
                sb.append("5 4 1 2 3");
                sb.append("\n");
                continue;
            }
            if (n % 2 == 0) {
                for (int i = n; i > 0; i--) {
                    sb.append(i + " ");
                }
            }
            else
            {
                int [] values = new int[n+1];
                for(int i=n; i>=0; i--)
                {
                    values[i]= i;
                }
                int m=n/2+1;
                values[m]=values[m]-1;
                values[m-1]=values[m-1]+1;
                for(int i=n; i>0; i--)
                {
                    sb.append(values[i] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
