import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class H_17144 {
    static int r;
    static int c;
    static int [][] map;
    static int t;
    static int [] dx={1,-1,0,0};
    static int [] dy={0,0,-1,1};
    static ArrayList <Point> cleaner;
    public static class Point
    {
        int x;
        int y;
        int value;
        public Point(int x,int y, int value)
        {
            this.x=x;
            this.y=y;
            this.value = value;
        }
    }
    static Queue <Point> queue;
    public static void find_dust()
    {
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(map[i][j]!=-1 && map[i][j]!=0)
                {
                    queue.add(new Point(i,j,map[i][j]));
                }
            }
        }
    }
    public static void expansion_dust()
    {
        while (!queue.isEmpty())
        {
           Point now_point = queue.poll();
           int nowx = now_point.x;
           int nowy = now_point.y;
           int value = now_point.value/5;
           int count=0;
           for(int i=0; i<4; i++)
           {
               int newx = nowx+dx[i];
               int newy = nowy+dy[i];
               if(newx<0 || newx>=r || newy<0 || newy>=c) continue;
               if(map[newx][newy]==-1) continue;
               count++;
               map[newx][newy]+=value;
           }
           int minus=count*value;
           map[nowx][nowy]-=minus;
        }
    }
    public static void start_clean()
    {
       Point clean = cleaner.get(0);
       int nowx = clean.x;
       int nowy =clean.y;
       for(int i=nowx-1; i>0; i--)
       {
           map[i][0]=map[i-1][0];
       }
       for(int i=0; i<c-1; i++)
       {
           map[0][i]=map[0][i+1];
       }
       for(int i=0; i<nowx; i++)
       {
           map[i][c-1]=map[i+1][c-1];
       }
       for(int i=c-1; i>nowy+1; i--)
       {
           map[nowx][i]=map[nowx][i-1];
       }
       map[nowx][nowy+1]=0;
       clean = cleaner.get(1);
       nowx=clean.x;
       nowy=clean.y;
        for(int i=nowx+1; i<r-1; i++)
        {
            map[i][0]=map[i+1][0];
        }
        for(int i=0; i<c-1; i++)
        {
            map[r-1][i]=map[r-1][i+1];
        }
        for(int i=r-1; i>nowx-1; i--)
        {
            map[i][c-1]=map[i-1][c-1];
        }
        for(int i=c-1; i>nowy+1; i--)
        {
            map[nowx][i]=map[nowx][i-1];
        }
        map[nowx][nowy+1]=0;
    }
    public static int get_sum()
    {
        int sum=0;
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(map[i][j]!=-1) sum+=map[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        r =sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        map = new int[r][c];
        queue = new LinkedList<Point>();
        cleaner = new ArrayList<Point>();
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                map[i][j]=sc.nextInt();
                if(map[i][j]==-1) cleaner.add(new Point(i,j,0));
            }
        }
        for(int i=0; i<t; i++)
        {
            find_dust();
            expansion_dust();
            start_clean();
        }
        int sum=get_sum();
        System.out.print(sum);
    }
}
