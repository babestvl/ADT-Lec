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

        ListNode[] nodes = new ListNode[n + m + 1];

        ListNode head = null;
        ListNode tail = null;

        for(int i=0; i<n; i++) {
            ListNode newNode = new ListNode(i+1);
            nodes[i+1] = newNode;

            if(tail != null) {
                tail.next = newNode;
                tail = newNode;
            } else {
                head = tail = newNode;
            }
        }

        for(int i=0; i<m; i++) {
            int ballNumber = n + i + 1;
            int pred = p[i];

            ListNode newNode = new ListNode(ballNumber);
            nodes[ballNumber] = newNode;

            ListNode currentNode = nodes[pred];

            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }

        ListNode currentNode = head;
        while(currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
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