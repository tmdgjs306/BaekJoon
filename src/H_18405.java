import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_18405 {
    public static class Node implements Comparable<Node>
    {
        int x;
        int y;
        int value;
        public Node(int x, int y, int value)
        {
            this.x=x;
            this.y=y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }
    static int N;
    static int K;
    static PriorityQueue <Node> queue = new PriorityQueue<>();
    static int[][] map;
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};
    public static void bfs()
    {
        int n = queue.size();
        Queue <Node> temp = new LinkedList<>();
        for(int t=0; t<n; t++) {
            Node now = queue.poll();
            int nowx = now.x;
            int nowy = now.y;
            int value = now.value;
            for (int i = 0; i < 4; i++) {
                int newx = nowx + dx[i];
                int newy = nowy + dy[i];
                if (newx <= 0 || newx > N || newy <= 0 || newy > N) continue;
                if (map[newx][newy] != 0) continue;
                else map[newx][newy] = value;
                temp.add(new Node(newx, newy, value));
            }
        }
        while (!temp.isEmpty()) {
            queue.add(temp.poll());
        }
    }
    public static void run(int s)
    {
        for(int i=0; i<s; i++)
        {
            bfs();
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bl = new StringBuilder();
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st3.nextToken());
        K = Integer.parseInt(st3.nextToken());
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
            {
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j]!=0) queue.add(new Node(i,j,map[i][j]));
            }
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int result_time = Integer.parseInt(st2.nextToken());
        int result_x = Integer.parseInt(st2.nextToken());
        int result_y = Integer.parseInt(st2.nextToken());
        run(result_time);
        bl.append(map[result_x][result_y]);
        System.out.println(bl);
    }
}
