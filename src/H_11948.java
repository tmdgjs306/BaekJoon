import java.util.PriorityQueue;
import java.util.Scanner;

public class H_11948 {
    static int [] parent;
    static class Path implements Comparable<Path>
    {
        int from;
        int to;
        int value;
        public Path(int from, int to, int value)
        {
            this.from = from;
            this.to = to;
            this. value = value;
        }
        @Override
        public int compareTo(Path o) {
            return this.value-o.value;
        }
    }
    public static int find(int a)
    {
        if(a==parent[a])
        {
            return a;
        }
        else
            return parent[a]=find(parent[a]);
    }
    public static void union(int a, int b)
    {
        int Pa=find(a);
        int Pb=find(b);
        if(Pa==Pb)
        {
            return;
        }
        else
        {
            parent[Pb]=Pa;
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        parent = new int[N+1];
        for(int i=1; i<=N; i++)
        {
            parent[i] = i;
        }
        PriorityQueue <Path> queue =new PriorityQueue<>();
        for(int i=0; i<M; i++)
        {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int value = sc.nextInt();
            Path temp = new Path(from,to,value);
            queue.offer(temp);
        }
        int result = 0;
        int count=0;
        while(!queue.isEmpty())
        {
            Path now = queue.poll();
            if(find(now.from)==find(now.to))
            {
                continue;
            }
            else
            {
                result+=now.value;
                union(now.from,now.to);
                if(++count==N-2)
                {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}

