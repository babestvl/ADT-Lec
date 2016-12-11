import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    int n;
    int[] xs;

    int[] keys;
    int[] values;
    int keyCount;

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        m.readInput();
        m.process();
    }

    private void process() {
        buildKeyArray();
        for(int i=0; i<n; i++) {
            int x = xs[i];
            int idx = binarySearch(x, 0, keyCount);  // your call to binary search here
            if(values[idx] == 0) {
                System.out.println("N");
                values[idx] = 1;
            } else {
                System.out.println("Y");
            }
        }
    }

    private int binarySearch(int x, int First, int Last) {
        // .....  your code here
        int mid = (First + Last)/2;
        if(x > keys[mid]) return binarySearch(x, mid + 1, Last);
        else if(x < keys[mid]) return binarySearch(x, First, mid - 1);
        return mid;
    }

    private void buildKeyArray() {
        int[] allKeys = new int[n];
        for(int i=0; i<n; i++) {
            allKeys[i] = xs[i];
        }
        Arrays.sort(allKeys);

        //count non-dup keys
        int c = 1;
        for(int i=1; i<n; i++) {
            if(allKeys[i] != allKeys[i-1]) {
                c++;
            }
        }
        keyCount = c;
        keys = new int[keyCount];
        values = new int[keyCount];

        keys[0] = allKeys[0];
        c = 1;
        for(int i=1; i<n; i++) {
            if(allKeys[i] != allKeys[i-1]) {
                keys[c] = allKeys[i];
                c++;
            }
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