import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.process();
    }

    private void process() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String st = reader.readLine();
            LinkedList<Term> terms = parseTerms(st);
            System.out.println(evaluate(terms));
        }
    }
    private int evaluate(LinkedList<Term> terms) {
        int result = 0;
        Stack<Term> stack = new Stack<>();
        while(!terms.isEmpty()) {
            if (terms.iterator().getVal().isCloseParen()) {
                Term b = stack.pop();
                Term o = stack.pop();
                Term a = stack.pop();
                stack.pop();
                Term num = new Term(o.performOperator(a.getVal(),b.getVal()));
                stack.push(num);
            }
            else {
                stack.push(terms.iterator().getVal());
            }
            terms.removeHead();
        }
        result = stack.pop().getVal();
        return result;

    }

    private LinkedList<Term> parseTerms(String st) {
        LinkedList<Term> output = new LinkedList<>();
        int i=0;
        while(i<st.length()) {
            char ch = st.charAt(i);
            if((ch >= '0') && (ch <= '9')) {
                int j = i;
                while((st.charAt(j) >= '0') && (st.charAt(j) <= '9')) {
                    j++;
                }

                String termStr = st.substring(i, j);
                output.add(new Term(termStr));

                i = j;
            } else {
                output.add(new Term("" + ch));
                i++;
            }
        }
        return output;
    }
}