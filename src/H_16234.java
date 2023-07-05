import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_16234 {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int l;
    static int r;
    static int [][] map;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static ArrayList<Node>[][] list;
    static boolean[][] visited;
    public static void check(){
        list = new ArrayList[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                list[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int now = map[i][j];
                for(int k=0; k<4; k++){
                    int newX = i+dx[k];
                    int newY = j+dy[k];
                    if(newX<0 || newX >=n || newY<0 || newY>=n) continue;
                    int gap = now-map[newX][newY];
                    if(gap>=l && gap<=r){
                        list[i][j].add(new Node(newX,newY));
                        list[newX][newY].add(new Node(i,j));
                    }
                }
            }
        }
    }

    static boolean isMove = false;
    public static void move(){
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                if(list[i][j].size()==0) continue;
                val=0;
                queue.add(new Node(i,j));
                visited[i][j] = true;
                bfs();
                int newVal = val/temp.size();
                while (!temp.isEmpty()){
                    Node tp = temp.poll();
                    map[tp.x][tp.y] = newVal;
                }
                isMove = true;
            }
        }
    }
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> temp = new LinkedList<>();
    static int val = 0;
    public static void bfs(){
        while (!queue.isEmpty()){
            Node node = queue.poll();
            val+=map[node.x][node.y];
            temp.add(node);
            for(int i=0; i<list[node.x][node.y].size(); i++){
                Node newNode = list[node.x][node.y].get(i);
                if(visited[newNode.x][newNode.y])continue;
                queue.add(new Node(newNode.x,newNode.y));
                visited[newNode.x][newNode.y] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        int count =0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true){
            isMove = false;
            check();
            move();
            if(!isMove)break;
            count++;
        }
        System.out.print(count);
    }
}
