import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_24229 {
    public static class Node implements Comparable<Node>{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start-o.start;
        }
    }
    public static class Person{
        int start;
        int end;
        int jump;
        public Person(int start, int end, int jump){
            this.start = start;
            this.end = end;
            this.jump = jump;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue <Node> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Node(start,end));
        }
        Node init = queue.poll();
        int start = init.start;
        int end = init.end;
        int jump = end-start;
        int now =end;
        Queue <Person> queue1 = new LinkedList<>();
        queue1.add(new Person(start,end,jump));
        while (!queue.isEmpty()){
            Node next = queue.poll();
            Queue<Person> temp = new LinkedList<>();
            while (!queue1.isEmpty()){
                Person p = queue1.poll();
                if(next.start>p.end){ // 다음으로 가려면 점프해야 하는 경우
                    int gap = next.start-p.end;
                    if(gap>p.jump) continue; // 다음 통나무에 도달 할 수 없는 경우
                    else{
                        temp.add(new Person(next.start,next.end,next.end-next.start)); // 점프하는 경우
                        temp.add(p); // 점프 하지 않는 경우
                    }
                }
                else if(next.end>p.end){ // 점프하지 않고 이동하는 경우
                    temp.add(new Person(p.start,next.end,next.end-p.start));
                }
                else{
                    temp.add(p);
                }
            }
            while (!temp.isEmpty()){;
                Person p = temp.poll();
                now = Math.max(now,p.end);
                queue1.add(p);
            }
        }
        System.out.print(now);
    }
}
