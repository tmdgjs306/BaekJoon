import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_14940 {
    static int n;
    static int m;
    static int [][] map;
    static boolean [][] visited;
    public static Queue <Node> queue = new LinkedList();
    public static int [] dx ={0,0,1,-1};
    public static int [] dy ={1,-1,0,0};
    public static class Node
    {
        int x;
        int y;
        public Node(int x, int y)
        {
            this.x= x;
            this.y = y;
        }
    }
    static int [][] dist;
    public static void bfs()
    {
        while (!queue.isEmpty())
        {
            Node nowNode = queue.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;
            for(int i=0; i<4; i++)
            {
                int newX=nowX+dx[i];
                int newY=nowY+dy[i];
                if(newX>=n || newX <0 || newY <0 || newY>=m) continue;
                if(visited[newX][newY]) continue;
                if(map[newX][newY]==0)
                {
                    dist[newX][newY] = 0;
                    continue;
                }
                visited[newX][newY] = true;
                dist[newX][newY] = Math.min(dist[newX][newY],dist[nowX][nowY]+1);
                queue.add(new Node(newX,newY));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n][m];
        map = new int[n][m];
        dist= new int[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                map[i][j] =sc.nextInt();
                if(map[i][j]==2)
                {
                    queue.add(new Node(i,j));
                    visited[i][j] = true;
                    dist[i][j]=0;
                }
                else
                {
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        bfs();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(map[i][j]==0) {
                    System.out.print(0 + " ");
                    continue;
                }
                if(dist[i][j]==Integer.MAX_VALUE)
                    System.out.print(-1+" ");
                else
                    System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
}
