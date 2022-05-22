import java.util.Scanner;
import java.util.Stack;

public class H_10773 {
    public static void main(String[] args) {
        Stack s = new Stack<>();
        Scanner sc =new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0; i<n; i++)
        {
            int temp=sc.nextInt();
            if(temp==0)
            {
                s.pop();
            }
            else
            {
                s.push(temp);
            }
        }
        int sum=0;
        while(!s.isEmpty())
        {
            sum+= (int) s.pop();
        }
        System.out.println(sum);
    }
}