import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class H_25194
{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int [] a=new int[N+1];
        for(int i=1; i<=N; i++)
        {
            a[i]=sc.nextInt();
        }
        Integer[] nums = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Arrays.sort(nums,Collections.reverseOrder());
        int max=0;
        for(int i=0; i<N; i++)
        {
            int index=i+1;
            if(index%3==0)
            {
                continue;
            }
            else
            {
                max+=nums[i];
            }
        }
        System.out.println(max);
    }
}
