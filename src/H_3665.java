import java.util.*;

public class H_3665{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=0; t<T; t++)
        {
            int N = sc.nextInt();
            boolean [][] Map= new boolean[N+1][N+1];
            int [] tp = new int[N+1];
            for(int i=0; i<N; i++)
            {
                int temp = sc.nextInt();
                tp[temp]=i;
                for(int j=1; j<=N; j++)
                {
                    if(j!=temp && !Map[j][temp])
                        Map[temp][j] = true;
                }
            }
            int m =sc.nextInt();
            for(int i=0; i<m; i++)
            {
                int t1=sc.nextInt();
                int t2=sc.nextInt();
                if(Map[t1][t2])
                {
                    Map[t1][t2]=false;
                    Map[t2][t1]=true;
                    tp[t1]++;
                    tp[t2]--;
                }
                else
                {
                    Map[t1][t2]=true;
                    Map[t2][t1]=false;
                    tp[t1]--;
                    tp[t2]++;
                }
            }
            Queue <Integer> queue = new LinkedList<>();
            ArrayList <Integer> result = new ArrayList<>();
            boolean is_right=true;
            boolean is_possible =true;
            for(int i=1; i<=N; i++)
            {
                if(tp[i]==0)
                {
                    queue.add(i);
                }
            }

            for(int i=1;i<=N; i++)
            {
                if(queue.size()==0)
                {
                    is_possible= false;
                    break;
                }
                if(queue.size()>1)
                {
                    is_right=false;
                    break;
                }
                int temp= queue.poll();
                result.add(temp);
                for(int j=1; j<=N; j++)
                {
                    if(Map[temp][j])
                    {
                        Map[temp][j]=false;
                        if(--tp[j]==0) queue.offer(j);
                    }
                }
            }
            if(is_possible)
            {
                if (is_right) {
                    for (int i = 0; i < result.size(); i++) {
                        System.out.print(result.get(i)+" ");
                    }
                } else {
                    System.out.print("?");
                }
            }
            else
            {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }

    }
}