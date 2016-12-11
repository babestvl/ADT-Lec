import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        main.process();
    }

    int n,m;

    List<Integer> [] adjList;
    List<Integer> [] adjList2;
    int[] levels;

    private void process() {
        readInput();

    }
    private void findFacebook() {
        int highest = 0;
        for (int i = 0; i < n; i++) {
            if (adjList[i].size() > adjList[highest].size()) {
                highest = i;
            }
        }
        System.out.println(highest);
    }
    private void findTwitter() {
        int inMax=0,outMax=0;
        for (int i = 0; i < n; i++) {
            if (adjList[i].size() > adjList[outMax].size()) {
                outMax = i;
            }
            if (adjList2[i].size() > adjList2[inMax].size()) {
                inMax = i;
            }
        }
        System.out.println(outMax);
        System.out.println(inMax);
    }
    private void findLevel(int s) {
        List<Integer> nextLevel = new ArrayList<>();

        for (int u = 0; u < n; u++) {
            levels[u] = -1;
        }
        levels[s] = 0;
        nextLevel.add(s);
        while (!nextLevel.isEmpty()) {
            List<Integer> currentLevel = nextLevel;
            nextLevel = new ArrayList<>();

            for (int u : currentLevel) {
                for (int v : adjList[u]) {
                    if (levels[v] == -1) {
                        levels[v] = levels[u]+1;
                        nextLevel.add(v);
                    }
                }
            }
        }
    }

    private void readInput() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );

        try {
            String[] items = reader.readLine().split(" ");

            n = Integer.parseInt(items[0]);
            m = Integer.parseInt(items[1]);

            adjList = (List<Integer>[])(new List[n]);
            for(int i=0; i<n; i++) {
                adjList[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<m; i++) {
                items = reader.readLine().split(" ");
                int u = Integer.parseInt(items[0]);
                int v = Integer.parseInt(items[1]);

                //Facebook
                adjList[u].add(v);
                adjList[v].add(u);

                //Twitter
                adjList[u].add(v);
                adjList2[v].add(u);

            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}