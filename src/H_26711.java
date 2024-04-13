import java.math.BigInteger;
import java.util.Scanner;

public class H_26711 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b=  sc.next();
        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);
        BigInteger result = a1.add(b1);
        System.out.println(result);
    }
}
