import java.util.Scanner;
import java.util.Stack;

public class H_11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack <Integer>stack = new Stack();
        int plus =1;
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
        {
            int now = sc.nextInt();
            if(now>=plus)
            {
                for(int j=plus; j<=now; j++)
                {
                    sb.append("+").append("\n");
                    stack.push(j);
                }
                sb.append("-").append("\n");
                stack.pop();
                plus=now+1;
            }
            else
            {
                if(stack.isEmpty())
                {
                    System.out.println("NO");
                    return;
                }
                if(stack.pop()!=now)
                {
                    System.out.println("NO");
                    return;
                }
                else
                {
                    sb.append("-").append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}
