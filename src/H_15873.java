import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class H_15873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int sum = 0;
        if(s.length()==4){
            sum = 20;
        }
        else if(s.length()==3){
            String a = s.substring(0,2);
            String b = s.substring(2,3);
            if(Integer.parseInt(a)>10){
                a = s.substring(0,1);
                b = s.substring(1,3);
            }
            sum = Integer.parseInt(a)+Integer.parseInt(b);
        }
        else{
            String a = s.substring(0,1);
            String b = s.substring(1,2);
            sum = Integer.parseInt(a)+Integer.parseInt(b);
        }
        System.out.print(sum);
    }
}
