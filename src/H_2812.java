import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class H_2812 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String num = sc.next();
        int len = n - k;
        Stack <Character> stack = new Stack<>();
        for(int i = 0; i < num.length() ; i++){
            if(!stack.empty()){
                while(!stack.empty() && k > 0 && stack.peek() < num.charAt(i)){
                    stack.pop();
                    k--;
                }
            }
            stack.push(num.charAt(i));
        }
        while(true){
            if(stack.size() == len) break;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder(stack.toString());
        String s = stack.toString();
        s = s.replaceAll("[[, ]]","");
        s = s.replace("[","");
        s = s.replace("]","");
        System.out.print(s);
    }
}
