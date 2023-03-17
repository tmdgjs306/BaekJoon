import java.util.Arrays;
import java.util.Scanner;

public class H_16435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int zero = 0;
        int one = 0;
        char now = s.charAt(0);
        if(now =='0')
            zero++;
        else
            one++;
        for(int i=1; i<s.length(); i++)
        {
            if(s.charAt(i-1)!=s.charAt(i))
            {
                if(s.charAt(i)=='0')
                    zero++;
                else
                    one++;
            }
        }
            System.out.print(Math.min(zero,one));
    }
}
