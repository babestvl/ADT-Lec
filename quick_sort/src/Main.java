import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    int n;
    int[] x;

    public static void main(String[] args) {
        Main m = new Main();

        m.readInput();
        m.process();
        m.output();
    }

    private void process() {
        quickSort(x, 0, n-1);
    }

    private void swap(int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    private void quickSort(int[] x, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = x[right];

        int mid = partition(x, left, right-1, pivot);
        swap(mid, right);

        quickSort(x, left, mid-1);
        quickSort(x, mid+1, right);
    }

    private int partition(int[] x, int a, int b, int pivot) {
        while (a <= b) {
            if (x[a] > pivot) {
                swap(a, b);
                b--;
            } else {
                a++;
            }
        }
        return a;

    }

    private void output() {
        for(int i=0; i<n; i++) {
            System.out.println(x[i]);
        }
    }

    private void readInput() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        try {
            n = Integer.parseInt(reader.readLine());
            x = new int[n];

            for(int i=0; i<n; i++) {
                x[i] = Integer.parseInt(reader.readLine());
            }
        } catch(Exception e) {
            System.out.println("Input error");
            n = 0;
            x = null;
        }
    }
}