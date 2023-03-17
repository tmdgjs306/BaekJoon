import java.util.ArrayList;
import java.util.Scanner;

public class H_2644 {
    static ArrayList <Integer> [] list;
    static int a;
    static int b;
    static int result = -1;
    static boolean [] visited;
    public static void find(int n,int count)
    {
        visited[n]= true;
        for(int i=0; i<list[n].size(); i++)
        {
            int temp = list[n].get(i);
            if(temp == b)
            {
                result = count;
                return;
            }
            else if(!visited[temp])
            {
                find(temp,count+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        int m = sc.nextInt();
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++)
        {
            list[i]= new ArrayList<>();
        }
        for(int i=0;i<m; i++)
        {
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(to);
            list[to].add(from);
        }
        find(a,1);
        System.out.println(result);
    }
}
