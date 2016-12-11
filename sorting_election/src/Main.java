import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long time1 = 0;
    static long time2 = 0;
    State[] states;
    int n;

    public static void main(String[] args) {
        Main m = new Main();
        time1 = System.nanoTime();

        m.readInput();
        m.process();
        m.output();

        time2 = System.nanoTime();
        System.out.print((1.0E-9)*(time2-time1));
    }

    private void process() {
        quickSort(states, 0, n-1);
    }

    private void swap(int i, int j) {
        State tmp = states[i];
        states[i] = states[j];
        states[j] = tmp;
    }

    private void quickSort(State[] x, int left, int right) {
        if(left >= right) {
            return;
        }
        double pivot = x[right].getObamaPercentage();

        int mid = partition(x, left, right-1, pivot);
        swap(mid, right);

        quickSort(x, left, mid-1);
        quickSort(x, mid+1, right);
    }

    private int partition(State[] x, int a, int b, double pivot) {
        while (a <= b) {
            if (x[a].getObamaPercentage() < pivot) {
                swap(a, b);
                b--;
            } else {
                a++;
            }
        }
        return a;
    }

    private void output() {
        System.out.println("County                                     Obama     Romney   Obama%   Romney%");
        System.out.println("-------------------------------------------------------------------------------");
        for (int i = 0; i < 4074; i++) {
            if (states[i].getFIPS() != 0)
                System.out.println(states[i].toString());
        }
    }

    private void readInput() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        try {
            n = 4074;
            String ss = reader.readLine();
            states = new State[n];

            for(int i=0; i<n; i++) {
                String[] str = reader.readLine().split(",");
                states[i] = new State(str[0],str[1],Integer.parseInt(str[2]),Integer.parseInt(str[3]),Integer.parseInt(str[4]));
            }
        } catch(Exception e) {
            System.out.println("Input error");
            states = null;
        }
    }
}