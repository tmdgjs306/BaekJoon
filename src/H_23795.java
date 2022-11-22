import java.util.Scanner;

public class H_23795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true)
        {
            int temp = sc.nextInt();
            if(temp==-1)
            {
                System.out.println(sum);
                break;
            }
            sum+=temp;
        }
    }
}
