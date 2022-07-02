import java.util.*;

public class H_1753 {
    static int v,e,k;
    static ArrayList<Edge>[] list;
    static int[] dist;
    static class Edge implements Comparable<Edge> {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
             return weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        int start =sc.nextInt();
        list =new ArrayList[V+1];
        dist = new int [V+1];
        for(int i=0; i<=V; i++)
        {
            list[i]=new ArrayList<>();
        }
        for(int i=0; i<E; i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int value =sc.nextInt();
            list[a].add(new Edge(b,value));
        }
        Arrays.fill(dist,10000000);
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start,0));
        dist[start]=0;
        while(!queue.isEmpty())
        {
          Edge now = queue.poll();
          if(now.weight > dist[now.dest]) continue;
          int len = list[now.dest].size();
          for(int i=0; i<len; i++)
          {
              Edge next = (Edge) list[now.dest].get(i);
              if(dist[next.dest] > now.weight+next.weight)
              {
                  dist[next.dest] = now.weight + next.weight;
                  queue.add(new Edge(next.dest,dist[next.dest]));
              }
          }
        }
        for(int i=1; i<=V; i++)
        {
            if(dist[i]==10000000)
                System.out.println("INF");
            else
            {
                System.out.println(dist[i]);
            }
        }
    }
}