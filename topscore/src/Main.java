import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
    int m,k;
    TreeMap<Integer,Integer> map = new TreeMap<>();
    TreeSet<Team> set = new TreeSet<>();

    public static void main(String[] args) {
        Main m = new Main();
        m.process();
    }
    private void process() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        try {
            String[] str = reader.readLine().split(" ");
            m = Integer.parseInt(str[0]);
            k = Integer.parseInt(str[1]);
            ArrayList<Integer> keys = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < m; i++) {

                str = reader.readLine().split(" ");
                int value = 0;
                if (map.get(Integer.parseInt(str[0])) != null) {
                    value = map.get(Integer.parseInt(str[0]));
                } else {
                    keys.add(Integer.parseInt(str[0]));
                }
                map.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]) + value);
                for (int a : keys) {
                    Team t = new Team(a,map.get(a));
                    set.add(t);
                }
                if (++count == k) {
                    int c = 0;
                     for(Team team : set) {
                         if (c++ < 10) {
                             System.out.println(team.toString());
                         }
                     }
                     count = 0;
                     System.out.println();
                }
                set.clear();
            }
        } catch(Exception e) {
            e.printStackTrace();
            m = k = 0;
        }
    }
}
