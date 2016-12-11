import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int n,m;
    private int[] c; //color of the ball in sequence
    private int[] d; //color of the ball in my hand
    private int[] p; //position that we shoot the ball to
    private FlexiArray<Integer> locationarray;

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        main.process();
    }

    private void process() throws IOException {
        readInput();
        // ... do something here

        int ballNumber = 0;
        int location;

        for( int i = 0 ; i < n ; i++ ) {
            ballNumber++;
            locationarray.insert( i, ballNumber);
        }

        for( int i = 0 ; i < m ; i++ ) {
            ballNumber++;
            int pred = p[i];

            location = locationarray.findIndex((Integer num) -> (num == pred) );

            locationarray.insert( location + 1, ballNumber);
        }


        for( int i = 0 ; i < n + m ; i++ ) {
            System.out.println( locationarray.get( i ) );
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
        locationarray  = new FlexiArray<Integer>( m + n );

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
