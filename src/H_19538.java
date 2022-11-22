import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class H_19538 {
    static int n;
    static ArrayList <Integer> [] list;
    static int val [];
    static int fr [];
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        val = new int [n+1];
        list = new ArrayList[n+1];
        fr = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=1; i<=n; i++)
        {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
            {
                int temp = Integer.parseInt(st.nextToken());
                if(temp!=0)
                {
                    list[i].add(temp);
                }
            }
        }

        Queue<Integer> next = new LinkedList<>();
        int trash = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
        {
            int temp = Integer.parseInt(st.nextToken());
            next.add(temp);
            visited[temp]=true;
        }
        int now = 0;
        Arrays.fill(val,-1);
        while (!next.isEmpty())
        {
            int t = next.size();
            for(int i=0; i<t; i++)
            {
                int nt = next.poll();
                val[nt] = now;
                for(int j=0; j<list[nt].size(); j++)
                {
                    int tp = list[nt].get(j);
                    if(visited[tp]) continue;
                    fr[tp]++;
                    int check = list[tp].size()%2;
                    int check_value = list[tp].size()/2;
                    if(check!=0)
                    {
                        check_value+=1;
                    }
                    if(check_value<=fr[tp])
                    {
                        next.add(tp);
                        visited[tp]=true;
                    }
                }
            }
            now++;
        }
        for(int i=1; i<=n; i++)
        {
            System.out.print(val[i]+" ");
        }
    }
}
