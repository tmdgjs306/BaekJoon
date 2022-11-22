import java.util.Scanner;

public class HH_a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append("int a;\n");
        sb.append("int *ptr = &a;\n");
        for(int i=2; i<=n; i++)
        {
            sb.append("int ");
            for(int j=0; j<i; j++) sb.append("*");
            if(i==2)
            {
                sb.append("ptr"+i+" = &ptr"+";\n");
            }
            else {
                sb.append("ptr"+i+" = &ptr"+(i-1)+";\n");
            }
        }
        System.out.print(sb);
    }
}
