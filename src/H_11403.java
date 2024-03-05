import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_11403 {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int n;
    public static boolean [][] visited;
    public static Queue<Integer> queue = new LinkedList<>();
    public static LinkedList<Integer> [] list;
    public static void bfs(int now){
        while (!queue.isEmpty()){
            int tp = queue.poll();
            for(int i=0; i<list[tp].size(); i++){
                int next = list[tp].get(i);
                if(!visited[now][next]){
                    visited[now][next] = true;
                    queue.add(next);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new LinkedList[n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            list[i] = new LinkedList<>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int temp = sc.nextInt();
                if(temp==0) continue;
                else{
                    list[i].add(j);
                }
            }
        }

        for(int i=0; i<n; i++){
            queue.add(i);
            bfs(i);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]){
                    System.out.print(1+" ");
                }
                else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }

    }
}
