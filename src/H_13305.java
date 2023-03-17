import java.util.Scanner;

public class H_13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dist = new int[n-1];
        int [] value = new int[n];
        for(int i=0; i<n-1; i++) {
            dist[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            value[i] = sc.nextInt();
        }
        value[n-1]=Integer.MAX_VALUE;
        int index = 0;
        long result=0;
        while (true) {
            if(index>=n-1)
                break;
            long nowValue =value[index];
            int count=1;
            long gets =dist[index];
            for(int j=index+1; j<n-1; j++)
            {
                if(value[j]<nowValue) {
                    break;
                }
                else
                {
                    count+=1;
                    gets+=dist[j];
                }
            }
            result+=nowValue*gets;
            index+=count;
        }
        System.out.println(result);
    }
}
