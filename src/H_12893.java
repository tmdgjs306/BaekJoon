import java.util.Scanner;

public class H_12893{
    static int [] parent;
    public static int find(int a)
    {
        if(parent[a] == a)
        {
            return a;
        }
        else return parent[a]=find(parent[a]);
    }
    public static void union(int a, int b)
    {
        int Pa = find(a);
        int Pb = find(b);
        parent[Pb]=Pa;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            parent[i] = i;
        }
        for(int i=0; i<m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(find(parent[a])==find(parent[b]))
            {
                System.out.println(0);
                return;
            }
            union(a,b);
        }
        System.out.println(1);
    }
}
