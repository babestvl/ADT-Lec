import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    int n,m;
    int[] rs;
    int[] xs;

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        m.readInput();
        m.process();
    }

    private void process() {
        // your code here
        TreeSet<Integer> t = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            t.add(rs[i]);
        }

        for (int i = 0; i < m; i++) {
           if (t.ceiling(xs[i]) != null) {
                System.out.println(t.ceiling(xs[i]));
            } else {
                System.out.println("-1");
            }

        }
    }

    private void readInput() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        String[] items = reader.readLine().split(" ");

        n = Integer.parseInt(items[0]);
        m = Integer.parseInt(items[1]);

        rs = new int[n];
        xs = new int[m];

        for(int i=0; i<n; i++) {
            rs[i] = Integer.parseInt(reader.readLine());
        }

        for(int i=0; i<m; i++) {
            xs[i] = Integer.parseInt(reader.readLine());
        }
    }
}