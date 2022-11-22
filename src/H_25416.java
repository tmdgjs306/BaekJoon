import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_25416{
    public static class Point
    {
        int x;
        int y;
        int value;
        public Point(int x,int y,int value)
        {
            this.x=x;
            this.y=y;
            this.value = value;
        }
    }

    static Queue <Point> queue = new LinkedList<>();
    static int [][] map;
    static boolean [][] visited;
    static boolean is_end = false;
    static int [] dx ={-1,1,0,0};
    static int [] dy = {0,0,1,-1};
    static int min = Integer.MAX_VALUE;
    public static void bfs() {
        while(!queue.isEmpty())
        {
            Point now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;
            if(map[nowX][nowY]==1)
            {
                min = Math.min(min,now.value);
                is_end =true;
            }
            for(int i=0; i<4; i++)
            {
                int sx = dx[i];
                int sy = dy[i];
                int newx =nowX+sx;
                int newy =nowY+sy;
                int tempx = nowX;
                int tempy = nowY;
                if(newx>=5 || newx<0 || newy>=5 || newy<0) continue;
                if(map[newx][newy]==-1) continue;
                if(!visited[newx][newy])
                {
                    queue.add(new Point(newx, newy, now.value + 1));
                    visited[newx][newy]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[5][5];
        visited = new boolean[5][5];
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        int nowx = sc.nextInt();
        int nowy = sc.nextInt();
        queue.add(new Point(nowx,nowy,0));
        visited[nowx][nowy]=true;
        bfs();
        if(!is_end) {
            System.out.print(-1);
        }
        else
        {
            System.out.print(min);
        }
    }
}