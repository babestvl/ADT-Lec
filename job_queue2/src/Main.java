import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int n = 0;
    private int k = 0;
    private Job[] jobs;

    public static void main(String[] args) {
        Main m = new Main();
        m.process();
    }

    private void process() {
        readInput();
        // ... your code here

        Queue<Integer>[] q = new Queue[k+1];

        for (int i = 0; i < k+1; i++) {
            q[i] = new Queue<>();
        }
        for (int j = 0; j < n; j++) {
            q[jobs[j].getNextServerId()].add(j);
        }
        int done = 0;
        while(true) {
            for (int x = 0; x < k; x++) {
                int temp;
                if (!q[x].isEmpty()) {
                    temp = q[x].remove();
                    jobs[temp].markCurrentStepDone();
                    if (jobs[temp].isDone()) {
                        done++;
                        System.out.println(jobs[temp].id);
                    } else {
                        q[k].add(temp);
                    }
                }
            }
            while(!q[k].isEmpty()){
                int temp = q[k].remove();
                q[jobs[temp].getNextServerId()].add(temp);
            }
            if (done == n) {
                break;
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
            jobs = new Job[n];

            for(int i=0; i<n; i++) {
                jobs[i] = new Job(i, reader.readLine());
            }
        } catch (Exception e) {
            System.out.println("Input error");
            n = 0;
            k = 0;
        }
    }
}
