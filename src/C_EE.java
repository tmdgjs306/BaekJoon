import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C_EE {
    public static void main(String[] args) throws IOException {
        Scanner sc  = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int[] que = new int[q];
            ArrayList<Long> list = new ArrayList<>();
            HashMap<Long,Long> hashMap = new HashMap<>();
            long max_increse = 0;
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
                if (arr[i] > max_increse) {
                    max_increse = arr[i];
                    list.add(max_increse);
                    hashMap.put(max_increse,sum);
                } else {
                    hashMap.put(max_increse,sum);
                }
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < q; j++) {
                que[j] = Integer.parseInt(st.nextToken());
                long temp = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (que[j] < list.get(i)) break;
                    else {
                        temp = hashMap.get(list.get(i));
                    }
                }
                sb.append(temp + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
