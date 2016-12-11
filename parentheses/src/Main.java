import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.process();
    }

    private void process() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        int t = Integer.parseInt(reader.readLine());

        for(int i=0; i<t; i++) {
            String st = reader.readLine();

            if(check(st)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private boolean check(String st) {
        // ... your code here

        Stack<Character> stack = new Stack<>();
        char[] chars = new char[st.length()];
        for (int i = 0; i < st.length();i++) {
            chars[i] = st.charAt(i);
        }
        for (int j = 0; j < st.length(); j++) {
            if (stack.isEmpty()) {
                stack.add(chars[j]);
            }
            else if (stack.peek()+1 == chars[j]) {
                stack.pop();
            }
            else if (stack.peek()+2 == chars[j]) {
                stack.pop();
            }
            else {
                stack.add(chars[j]);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }

    }
}