import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_1717 {
    static int []parent;
    public static int find(int n)
    {
        if(n ==parent[n])
        {
            return n;
        }
        else return parent[n]=find(parent[n]);
    }
    public static void union(int a, int b)
    {
        a=find(a);
        b=find(b);
        if(a!=b)
            parent[b]=a;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0; i<=N; i++)
        {
            parent[i]=i;
        }
        for(int i=0; i<M; i++)
        {
            StringTokenizer st1 =new StringTokenizer(bf.readLine());
            int order=Integer.parseInt(st1.nextToken());
            if(order == 0)
            {
                int a=Integer.parseInt(st1.nextToken());
                int b=Integer.parseInt(st1.nextToken());
                union(a,b);
            }
            else if(order==1)
            {
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());
                int rootA=find(a);
                int rootB=find(b);
                if(rootA==rootB)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}
