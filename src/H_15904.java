import java.util.Scanner;

public class H_15904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int find = 0;
        for(int i=0; i<s.length(); i++){
            if(find == 0){
                if(s.charAt(i)=='U'){
                    find++;
                }
            }
            else if(find == 1){
                if(s.charAt(i)=='C'){
                    find++;
                }
            }
            else if(find == 2){
                if(s.charAt(i)=='P'){
                    find++;
                }
            }
            else{
                if(s.charAt(i)=='C'){
                    System.out.print("I love UCPC");
                    return;
                }
            }
        }
        System.out.print("I hate UCPC");
    }
}
