import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_21736 {
    static int count = 0;
    static int n;
    static int m;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx ={1,-1,0,0};
    static int [] dy ={0,0,1,-1};
    public static class Node
    {
        int x;
        int y;
        public Node(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    static Queue <Node> queue = new LinkedList<>();
    static public void bfs()
    {
        while (!queue.isEmpty())
        {
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            for(int i=0; i<4; i++)
            {
                int newX = nowX+dx[i];
                int newY = nowY+dy[i];
                if(newX<0 || newX>=n || newY<0 || newY>=m) continue;
                if(visited[newX][newY])continue;
                if(map[newX][newY]==2) continue;
                if(map[newX][newY]==1)
                {
                    count++;
                    visited[newX][newY] = true;
                    queue.add(new Node(newX,newY));
                }
                else
                {
                    visited[newX][newY] = true;
                    queue.add(new Node(newX,newY));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m=sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++)
        {
            String s = sc.next();
            for(int j=0; j<m; j++)
            {
                if(s.charAt(j)=='O')
                    map[i][j]=0;
                else if (s.charAt(j)=='P') {
                    map[i][j]=1;
                }
                else if(s.charAt(j)=='X')
                {
                    map[i][j]=2;
                }
                else
                {
                    map[i][j]=3;
                    queue.add(new Node(i,j));
                    visited[i][j]=true;
                }
            }
        }
        bfs();
        if(count==0)
            System.out.print("TT");
        else
            System.out.print(count);
    }
}
