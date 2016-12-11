import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    Map<Integer,Integer> table;

    public static void main(String[] args) throws IOException {
        Main m = new Main();

        m.process();
    }

    Main() {
        table = new HashMap<Integer, Integer>();
    }

    private void process() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        System.out.println("Hello!");
        while(true) {
            System.out.print("> ");
            String cmd = reader.readLine();

            if(cmd.equals("quit")) {
                return;
            }

            if(cmd.contains("=")) {
                String[] items = cmd.split("=");
                int cellNum = getCellNumber(items[0]);
                int val = Integer.parseInt(items[1]);

                table.put(cellNum, val);
            } else {
                int cellNum = getCellNumber(cmd);

                Integer val = table.get(cellNum);

                if(val == null) {
                    val = 0;
                }
                System.out.println(val);
            }
        }
    }

    private int getCellNumber(String location) {
        location = location.toUpperCase();
        try {
            int colNum = 0;
            int i = 0;
            while((location.charAt(i) >= 'A') &&
                    (location.charAt(i) <= 'Z')) {
                colNum = colNum * 26 + (location.charAt(i) - 'A');
                i++;
            }
            String rowStr = location.substring(i);
            int rowNum = Integer.parseInt(rowStr);
            return colNum * 1000000 + rowNum;
        } catch(Exception e) {
            return -1;
        }
    }
}