import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_16507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int [][] map = new int[r+1][c+1];
        int [][] sums = new int[r+1][c+1];

        for(int i=1; i<=r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sums[i][j] = sums[i][j-1]+map[i][j];
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());

            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            int count = 0;

            for(int j=y1; j<=y2; j++){
                sum += (sums[j][x2]-sums[j][x1-1]);
                count += (x2-x1+1);
            }
            result.append(sum/count).append("\n");
        }

        System.out.print(result);
    }
}
