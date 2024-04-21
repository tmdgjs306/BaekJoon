import java.util.Scanner;

public class H_14581 {
    public void a1(int a){
        a+=1;
    }
    public String a1(String a){
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String [][] strings = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                strings[i][j] = ":fan:";
            }
        }
        strings[1][1] = ":"+s+":";
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(strings[i][j]);
            }
            System.out.println();
        }
    }
}
