import java.util.Scanner;

public class H_24391 {
    static int [] parent;
    public static int find(int a)
    {
        if(a==parent[a]) return a;
        else return parent[a]=find(parent[a]);
    }
    public static void union(int a, int b)
    {
        int Pa = find(a);
        int Pb = find(b);
        parent[Pb]=Pa;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            parent[i]=i;
        }
        for(int i=0; i<m; i++)
        {
            int from = sc.nextInt();
            int to = sc.nextInt();
            union(from,to);
        }
        int now = sc.nextInt();
        int count = 0;
        for(int i=1; i<n; i++)
        {
            int go = sc.nextInt();
            int Pn = find(now);
            int Pg = find(go);
            if(Pn!=Pg) count++;
            now = go;
        }
        System.out.print(count);
    }
}
