import java.util.*;

public class H_5430 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int T= sc.nextInt();
        for(int i=0; i<T; i++)
        {
            String order;
            boolean reverse=false;
            order = sc.next();
            boolean er=false;
            int count=sc.nextInt();
            Deque <Integer> q=new LinkedList<>();
            if(count !=0)
            {
                String s = sc.next();
                String ss = s.substring(1, s.length() - 1);
                String[] a = ss.split(",");

                for (String v : a) {
                    q.add(Integer.parseInt(v));
                }
            }
            if(count==0)
            {
                String s= sc.next();
            }
            for(int t=0; t<order.length(); t++)
            {
                if(order.charAt(t)=='R')
                {
                    if(reverse)
                        reverse=false;
                    else
                        reverse=true;
                }
                else {
                    if (q.isEmpty()) {
                        er = true;
                    } else if (reverse) {
                        q.removeLast();
                    } else {
                        q.removeFirst();
                    }
                }
            }
            if(er)
            {
                System.out.println("error");
            }
            else if(!er && reverse)
            {
                StringBuilder br =new StringBuilder("[");
                int n = q.size();
                if(n==0)
                {
                    br.append("]");
                    System.out.println(br);
                    continue;
                }
                for(int j=0; j<n-1; j++)
                {
                    br.append(q.pollLast()+",");
                }
                br.append(q.pollLast());
                br.append("]");
                System.out.println(br);
            }
            else if(!er)
            {
                StringBuilder br =new StringBuilder("[");
                int n = q.size();
                if(n==0)
                {
                    br.append("]");
                    System.out.println(br);
                    continue;
                }
                for(int j=0; j<n-1; j++)
                {
                    br.append(q.pollFirst()+",");
                }
                br.append(q.pollFirst());
                br.append("]");
                System.out.println(br);
            }
        }
    }
}
