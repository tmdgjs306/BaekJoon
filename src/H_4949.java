import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class H_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String temp = br.readLine();
            if(temp.equals("."))break;
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int i=0; i<temp.length(); i++){
                char cmd = temp.charAt(i);
                switch (cmd){
                    case '[':
                        stack.push(cmd);
                        break;
                    case ']':
                        if(stack.isEmpty()){
                            flag = false;
                            break;
                        }
                        if(stack.peek()!='['){
                            flag = false;
                            break;
                        }
                        else {
                            stack.pop();
                            break;
                        }
                    case '(':
                        stack.push(cmd);
                        break;
                    case ')':
                        if(stack.isEmpty()){
                            flag = false;
                            break;
                        }
                        if(stack.peek()!='('){
                            flag = false;
                            break;
                        }
                        else
                            stack.pop();
                        break;
                }
            }
            if(!stack.isEmpty() || !flag){
                sb.append("no").append("\n");
            }
            else{
                sb.append("yes").append("\n");
            }
        }
        System.out.println(sb);
    }
}
