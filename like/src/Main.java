import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    int n;
    int[] xs;

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        m.readInput();
        m.process();
    }

    private void process() {
        // your code here
        Map<Integer,Integer> s = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (s.containsKey(xs[i])) {
                s.put(xs[i],s.get(xs[i])+1);
            } else {
                s.put(xs[i],1);
            }
            System.out.println(s.get(xs[i]));
        }

    }

    private void readInput() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        n = Integer.parseInt(reader.readLine());
        xs = new int[n];

        for(int i=0; i<n; i++) {
            xs[i] = Integer.parseInt(reader.readLine());
        }

    }
}