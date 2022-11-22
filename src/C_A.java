import java.util.Scanner;

public class C_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int T=0; T<t; T++)
        {
            String a = sc.next();
            String b = sc.next();
            char a_size =a.charAt(a.length()-1);
            char b_size =b.charAt(b.length()-1);
            if (a.equals(b))
            {
                sb.append("=\n");
                continue;
            }
            if(a_size==b_size && a_size=='S')
            {
                if(a.length()>b.length())
                {
                    sb.append("<\n");
                }
                else
                {
                    sb.append(">\n");
                }
            }
            else if(a_size==b_size && a_size!='S')
            {
                if(a.length()<b.length())
                {
                    sb.append("<\n");
                }
                else
                {
                    sb.append(">\n");
                }
            }
            else if(a_size!=b_size && a_size=='S')
            {
                sb.append("<\n");
            }
            else if(a_size!=b_size && a_size=='M')
            {
                if(b_size=='S')
                {
                    sb.append(">\n");
                }
                else
                {
                    sb.append("<\n");
                }
            }
            else {
                sb.append(">\n");
            }
        }
        System.out.println(sb);
    }
}
