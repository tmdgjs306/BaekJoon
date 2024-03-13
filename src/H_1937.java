import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class H_1937 {
    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;
        public Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }

        //가장 값이 큰 대나무 숲 부터 DP 배열에 값 저장
        @Override
        public int compareTo(Node o) {
            return o.value-this.value;
        }

    }
    static int n;
    static int [][] map;
    static PriorityQueue<Node> queue = new PriorityQueue<>();
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int [][] dp;
    static int max = 0;
    public static void bfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];
                if(newX>=n || newX<0 || newY>=n || newY<0) continue;
                if(map[newX][newY]<=node.value)continue;
                else{
                    dp[node.x][node.y] = Math.max(dp[node.x][node.y],dp[newX][newY]+1);
                }
            }
            max = Math.max(dp[node.x][node.y],max);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n]; // 대나무 숲 값 저장
        dp = new int[n][n]; // 1로 값 초기화


        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i],1);
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                queue.add(new Node(i,j,map[i][j]));
            }
        }

        bfs();
        System.out.print(max);
    }
}
