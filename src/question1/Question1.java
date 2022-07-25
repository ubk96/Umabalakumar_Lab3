package question1;
import java.util.*;

public class Question1 {

	static boolean areBracketsBalanced(String expr)
    {
        Deque<Character> stack
            = new ArrayDeque<Character>();
  
        for (int i = 0; i < expr.length(); i++) 
        {
            char x = expr.charAt(i);
  
            if (x == '(' || x == '[' || x == '{') 
            {
                stack.push(x);
                continue;
            }
  

            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
  
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
  
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
  
        return (stack.isEmpty());
    }
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String expr = sc.next();
	        if (areBracketsBalanced(expr))
	            System.out.println("The entered String has Balanced Brackets\r\n");
	        else
	            System.out.println("The entered Strings do not contain Balanced Brackets\r\n");

		}
	}

}
