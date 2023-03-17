import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_11725_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Integer> [] list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(to);
            list[to].add(from);
        }
        int [] parent = new int[n+1];
        Queue <Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean [] visited = new boolean[n+1];
        visited[1] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<list[now].size(); i++){
                int next = list[now].get(i);
                if(visited[next]) continue;
                parent[next]=now;
                queue.add(next);
                visited[next] = true;
            }
        }
        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }
}
