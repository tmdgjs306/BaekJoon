import java.util.Scanner;

public class H_2743 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int n = sc.nextInt();
        int count = 0 ;
        for(int i=0; i<n; i++)
        {
            String b = sc.next();
            if(a.equals(b))count++;
        }
        System.out.println(count);
    }
}
