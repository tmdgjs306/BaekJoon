import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_1092 {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bf.readLine());
        ArrayList<Integer> c =new ArrayList();
        StringTokenizer st =new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens())
        {
            c.add(Integer.parseInt(st.nextToken()));
        }
        c.sort(Collections.reverseOrder());
        int box=Integer.parseInt(bf.readLine());
        ArrayList<Integer> boxs =new ArrayList();
        StringTokenizer st2 =new StringTokenizer(bf.readLine());
        while(st2.hasMoreTokens())
        {
            boxs.add(Integer.parseInt(st2.nextToken()));
        }
        boxs.sort(Collections.reverseOrder());
        int count=0;
        if(c.get(0)<boxs.get(0))
        {
            System.out.println(-1);
            return;
        }
        else {
            while(!boxs.isEmpty()) {
                int idx = 0;
                for(int i = 0; i < c.size();) {
                    if(idx == boxs.size()) break;
                    else if(c.get(i) >= boxs.get(idx)) {
                        boxs.remove(idx);
                        i++;
                    }
                    else idx++;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
