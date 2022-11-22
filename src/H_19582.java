import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_19582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Long n = Long.parseLong(br.readLine());
        long skip = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long now = Long.parseLong(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            if (sum <= now)
            {
                sum += value;
                queue.add(value);
            }
            else
            {
                if (skip == 1)
                {
                    System.out.println("Zzz");
                    return;
                }
                else
                {
                    sum -= queue.peek();
                    if (sum > now)
                    {
                        sum += queue.peek();
                    }
                    else if(queue.peek()>value)
                    {
                        sum += value;
                    }
                    else
                    {
                        sum +=queue.peek();
                    }
                    skip = 1;
                }
            }
        }
        System.out.println("Kkeo-eok");
    }
}