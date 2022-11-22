import java.util.Scanner;

public class H_17388 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a==b&&b==c&&a==60)
        {
            System.out.println("Equilateral");
            return;
        }
        if(a+b+c ==180 && (a==b || b==c||a==c))
        {
            System.out.println("Isosceles");
            return;
        }
        if(a+b+c == 180 && a!=b && b!=c && a!=c)
        {
            System.out.println("Scalene");
            return;
        }
        if(a+b+c!=180)
        {
            System.out.println("Error");
        }
    }
}
