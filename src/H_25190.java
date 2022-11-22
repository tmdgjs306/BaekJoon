import java.util.PriorityQueue;
import java.util.Scanner;

public class H_25190 {
    public static class people implements Comparable <people>
    {
        int a;
        int b;
        public people(int a, int b)
        {
            this.a=a;
            this.b=b;

        }

        @Override
        public int compareTo(people o) {
            if(this.a>o.a)
                return 1;
            else if(this.a==o.a)
                return this.b-o.b;
            else return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue <people> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++)
        {
            int a = sc.nextInt();
            int b= sc.nextInt();
            queue.add(new people(a,b));
        }
        int now=0;
        int count=0;
        while (!queue.isEmpty())
        {
            people temp = queue.poll();
            if(now<temp.b)
            {
                now+=temp.a;
                count++;
            }
        }
        System.out.println(count+" "+now);
    }
}
