import java.util.Scanner;

public class H_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(m>=45){
            m-=45;
            System.out.println(n+" "+m);
        } else if (n==0 && m<45) {
            m-=45;
            m+=60;
            System.out.println(23+" "+m);
        }
        else{
            n-=1;
            m-=45;
            m+=60;
            System.out.println(n+" "+m);
        }
    }
}
