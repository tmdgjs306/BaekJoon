import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H_2684 {
    public static String [] coins = {"TTT","TTH","THT","THH","HTT","HTH","HHT","HHH"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<p; i++){
            String s = br.readLine();
            int [] map = new int[8];

            for(int j=0; j<=37; j++){
                String temp = s.substring(j,j+3);
                for(int k=0; k<8; k++){
                    if(temp.equals(coins[k])){
                        map[k]++;
                        break;
                    }
                }
            }

            for (int j=0; j<8; j++){
                sb.append(map[j]).append(" ");
            }

            if(i!=p-1)
                sb.append("\n");
        }
        System.out.print(sb);
    }
}
