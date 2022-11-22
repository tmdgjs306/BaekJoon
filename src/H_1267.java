import java.util.Scanner;

public class H_1267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        if(m<2)
        {
            System.out.println("Before");
            return;
        }
        if(m==2)
        {
            if(d == 18)
            {
                System.out.println("Special");
            }
            else if(d<18)
            {
                System.out.println("Before");
            }
            else
            {
                System.out.println("After");
            }
            return;
        }
        if(m>=3)
        {
            System.out.println("After");
        }
    }
}
