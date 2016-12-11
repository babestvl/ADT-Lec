import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private int n = 0;
    private int k = 0;
    private int [] s = null;

    public static void main(String[] args) {
        Main m = new Main();
        m.process();
    }

    private void process() {
        readInput();

        // ... your code here
        Queue<Integer>[] q = new LinkedList[k];
        for (int i = 0; i < k; i++) {
            q[i] = new LinkedList<>();
        }

        for (int j = 0; j < n; j++) {
            q[s[j]].add(j);
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < k; x++) {
                if (!q[x].isEmpty()) {
                    System.out.println(q[x].remove());
                }

            }
        }


    }

    private void readInput() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        try {
            String[] items = reader.readLine().split(" ");
            n = Integer.parseInt(items[0]);
            k = Integer.parseInt(items[1]);
            s = new int[n];
            for(int i=0; i<n; i++) {
                s[i] = Integer.parseInt(reader.readLine());
            }
        } catch (Exception e) {
            System.out.println("Input error");
            n = 0;
            k = 0;
        }
    }
}