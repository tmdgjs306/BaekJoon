import java.util.Scanner;

public class H_2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            int sum = 0;
            for(int j=0; j<4; j++){
                sum += sc.nextInt();
            }
            if(sum==0){
                sb.append("D").append("\n");
            }
            else if(sum==1){
                sb.append("C").append("\n");
            }
            else if(sum==2){
                sb.append("B").append("\n");
            }
            else if(sum==3){
                sb.append("A").append("\n");
            }
            else{
                sb.append("E").append("\n");
            }
        }
        System.out.print(sb);
    }
}
