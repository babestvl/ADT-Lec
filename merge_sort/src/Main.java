import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    int n;
    int[] x;
    int[] y;
    int[] z;

    public static void main(String[] args) {
        Main m = new Main();

        m.readInput();
        m.process();
        m.output();
    }

    private void process() {
        merge(x,y,z);
    }

    private void output() {
        for(int i=0; i<2*n; i++) {
            System.out.println(z[i]);
        }
    }

    private void merge(int[] x, int[] y, int[] z) {
        int xi = 0, yi = 0,zi = 0;
        while (zi != 2*n) {
            if (x.length == xi || yi != n && x[xi] > y[yi]) {
                z[zi] = y[yi++];
            }
            else {
                z[zi] = x[xi++];
            }
            zi++;
        }
    }

    private void readInput() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        try {
            n = Integer.parseInt(reader.readLine());
            x = new int[n];
            y = new int[n];
            z = new int[2*n];

            for(int i=0; i<n; i++) {
                x[i] = Integer.parseInt(reader.readLine());
            }
            for(int i=0; i<n; i++) {
                y[i] = Integer.parseInt(reader.readLine());
            }
        } catch(Exception e) {
            System.out.println("Input error");
            n = 0;
            x = null;
            y = null;
        }
    }
}