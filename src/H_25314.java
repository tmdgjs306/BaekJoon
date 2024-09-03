import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int repeat = n/4;

        for(int i=0; i<repeat; i++){
            sb.append("long").append(" ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}
