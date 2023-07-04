import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_7511 {
    static int [] Parent;
    public static int Find(int a){
        if(Parent[a] == a)
            return a;
        else return Parent[a]=Find(Parent[a]);
    }
    static int temp1;
    static int temp2;
    static int pTemp1;
    static int pTemp2;
    static int i;
    public static void Union(int a, int b){
        int Pa = Find(a);
        int Pb = Find(b);
        Parent[Pa] = Pb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int t;
        StringBuilder sb = new StringBuilder();
        for(t=0; t<T; t++){
            sb.append("Scenario ").append(t+1).append(":\n");
            int n = Integer.parseInt(br.readLine());
            Parent = new int[n];
            for(i=0; i<n; i++){
                Parent[i] = i;
            }
            int k = Integer.parseInt(br.readLine());
            for(i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                temp1 = Integer.parseInt(st.nextToken());
                temp2 = Integer.parseInt(st.nextToken());
                Union(temp1,temp2);
            }
            int m = Integer.parseInt(br.readLine());
            for(i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                temp1  = Integer.parseInt(st.nextToken());
                temp2 = Integer.parseInt(st.nextToken());
                pTemp1 = Find(temp1);
                pTemp2 = Find(temp2);
                if(pTemp1!=pTemp2){
                    sb.append(0).append("\n");
                }
                else
                    sb.append(1).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
