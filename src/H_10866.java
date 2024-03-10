import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class H_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.equals("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.equals("pop_front")){
                if(deque.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(deque.pollFirst()).append("\n");
                }
            }
            else if(cmd.equals("pop_back")){
                if(deque.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(deque.pollLast()).append("\n");
                }
            }
            else if(cmd.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(cmd.equals("empty")){
                if(deque.isEmpty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if(cmd.equals("front")){
                if(deque.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(deque.getFirst()).append("\n");
                }
            }
            else{
                if(deque.isEmpty()){
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(deque.getLast()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
