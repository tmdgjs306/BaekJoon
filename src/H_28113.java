import java.util.Scanner;

public class H_28113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int walk = sc.nextInt();
        int bus = sc.nextInt();
        int train = sc.nextInt();
        if(walk>train){
            System.out.println("Bus");
            return;
        }
        if(train==bus){
            System.out.println("Anything");
            return;
        } else if (train>bus) {
            System.out.println("Bus");
            return;
        }
        else{
            System.out.println("Subway");
            return;
        }
    }
}
