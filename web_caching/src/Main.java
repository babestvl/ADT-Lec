import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.process();

    }
    private void process() {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = reader.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int countMiss = 0;
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(reader.readLine());
                if (queue.size() < n) {
                    if(!queue.contains(x)) {
                        queue.add(x);
                        countMiss++;
                    }
                } else if (queue.size() == n) {
                    if(!queue.contains(x)) {
                        queue.poll();
                        queue.add(x);
                        countMiss++;
                    }
                }
            }
            System.out.println(countMiss);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
