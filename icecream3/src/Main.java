import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    void process() throws NumberFormatException, IOException {
        PriorityQueue<Customer> queue = new PriorityQueue<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );
        int m = Integer.parseInt(reader.readLine());
        for(int i=0; i<m; i++) {
            String items[] = reader.readLine().split(" ");
            if((items.length == 1) && (items[0].equals("2"))) {
                // get the first customer out
                System.out.println(queue.poll().id);
            } else {
                int numNewCustomer = Integer.parseInt(items[1]);
                for(int j=0; j<numNewCustomer; j++) {
                    int id = Integer.parseInt(items[2 + j * 2]);
                    int age = Integer.parseInt(items[2 + j * 2 + 1]);
                    // add this customer to the queue
                    queue.add(new Customer(id,age));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException  {
        Main main = new Main();

        main.process();
    }
}
