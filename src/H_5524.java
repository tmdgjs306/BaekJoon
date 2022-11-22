import java.util.Scanner;

public class H_5524 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max_index =0;
        int max =0;
        for(int i=0; i<5; i++)
        {
            int temp=0;
            for(int j=0; j<4; j++)
            {
                temp+=sc.nextInt();
            }
            if(temp>max)
            {
                max = temp;
                max_index=i+1;
            }
        }
        System.out.print(max_index+" "+max);
    }
}
