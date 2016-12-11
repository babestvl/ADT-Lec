import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int n,m;
    private int[] c;
    private int[] d;
    private int[] p;

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        main.process();
    }

    private void process() throws IOException {
        readInput();

        int ballNumber = 0;

        LinkedList<zoomaBall> zooma = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            ballNumber++;
            zoomaBall ball = new zoomaBall(i,ballNumber,c[i]);
            zooma.addHead(ball);
        }

        for (int j = 0; j < m; j++) {
            ballNumber++;
            int countSameColor = 0;
            int pred = p[j];
            int currentColor = d[j];
        }

    }

    private void readInput() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        String[] items = reader.readLine().split(" ");
        n = Integer.parseInt(items[0]);
        m = Integer.parseInt(items[1]);

        c = new int[n];
        d = new int[m];
        p = new int[m];

        for(int i=0; i<n; i++) {
            c[i] = Integer.parseInt(reader.readLine());
        }

        for(int j=0; j<m; j++) {
            items = reader.readLine().split(" ");
            d[j] = Integer.parseInt(items[0]);
            p[j] = Integer.parseInt(items[1]);
        }
    }
}