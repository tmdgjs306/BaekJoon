import java.util.Scanner;
import java.util.Stack;

public class H_9935 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.next();
        String boom=sc.next();
        Stack <Character> temp =new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            temp.push(s.charAt(i));
            if(temp.size()>=boom.length())
            {
                boolean is_boom=true;
                for(int j=0; j<boom.length(); j++)
                {
                    if(temp.get(temp.size()-boom.length()+j)!=boom.charAt(j))
                    {
                        is_boom=false;
                        break;
                    }
                }
                if(is_boom)
                {
                    for(int j=0; j<boom.length(); j++)
                        temp.pop();
                }
            }
        }
        StringBuilder result =new StringBuilder();
        for(Character c : temp)
        {
            result.append(c);
        }
        System.out.println(result.length()==0? "FRULA" : result.toString());
    }
}
