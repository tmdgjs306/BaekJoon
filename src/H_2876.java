import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class H_2876 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int doubleN = n*2;
        char [][]map = new char[doubleN][doubleN];
        for(int i=0; i<doubleN; i++){
            for(int j=0; j<doubleN; j++){
                map[i][j]='.';
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<=n+i; j++){
                if(Math.abs(j-n)<=i){
                    map[i][j]='*';
                    if(doubleN-i-2 == n-1) continue;
                    map[doubleN-i-2][j]='*';
                }
                else {
                    map[i][j] = ' ';
                    if(doubleN-i-2 == n-1) continue;
                    map[doubleN - i-2][j] = ' ';
                }
            }
        }
        for(int i=0; i<doubleN-1; i++){
            for(int j=0; j<doubleN; j++){
                if(map[i][j]=='.') break;
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
