import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_5567 {
    static int result =0;
    static ArrayList<Integer> list [];
    Queue queue = new LinkedList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        int m = sc.nextInt();
        boolean [] check = new boolean[n+1];
        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(to);
            list[to].add(from);
        }
        check[1] =true;
        Queue <Integer>queue1 = new LinkedList();
        for(int i=0; i<list[1].size(); i++){
            int nt = list[1].get(i);
            if(check[nt]) continue;
            check[nt] = true;
            queue1.add(nt);
            result++;
        }
        while (!queue1.isEmpty()){
            int now = queue1.poll();
            for(int i=0; i<list[now].size(); i++){
                int nt = list[now].get(i);
                if(check[nt]) continue;
                check[nt] = true;
                result++;
            }
        }
        System.out.print(result);
    }
}
