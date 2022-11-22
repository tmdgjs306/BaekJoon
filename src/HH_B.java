import java.util.Scanner;

public class HH_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price = sc.nextInt();
        int min =Integer.MAX_VALUE;
        if(n>=20)
        {
            int temp = (int) (price * 0.25);
            min =Math.min(price-temp,min);
        }
        if(n>=15)
        {
            min =Math.min(price-2000,min);
        }
        if(n>=10)
        {
            int temp =(int)(price*0.1);
            min =Math.min(price-temp,min);
        }
        if(n>=5)
        {
            min =Math.min(price-500,min);
        }
        if(min==Integer.MAX_VALUE)
        {
            System.out.println(price);
            return;
        }
        if(min<0)
        {
            System.out.println(0);
            return;
        }
        else {
            System.out.println(min);
        }
    }
}
