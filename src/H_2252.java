import java.util.*;

public class H_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int []indeg = new int[N];
        Queue <Integer> queue = new LinkedList<>();
        ArrayList<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=1; i<=N; i++)
        {
            graph.add(new LinkedList<Integer>());
        }
        for(int i=0; i<M;i++)
        {
            Integer from = sc.nextInt();
            Integer to = sc.nextInt();
            graph.get(from).add(to);
            indeg[to]++;
        }

    }
}
