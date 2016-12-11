import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    String[][] maze;
    Graph g;
    int[] levels;
    int[] parents;
    int x,y;
    int O = 0;
    int X = 0;

    public static void main(String[] args) {
        Main m = new Main();
        m.process();
    }

    private void process() {
        read();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (j < y-1 && !maze[i][j].equals("#") && !maze[i][j+1].equals("#")) {
                    g.addEdge(((i*y)+j),((i*y)+j)+1);
                }
                if (i < x-1 && !maze[i][j].equals("#") && !maze[i+1][j].equals("#")) {
                    g.addEdge(((i*y)+j),(((i+1)*y)+j));
                }
            }
        }


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (maze[i][j].equals("O")) {
                    O = (i*y)+j;
                }
                if (maze[i][j].equals("X")) {
                    X = (i*y)+j;
                }
            }
        }
        breadthFirstSearch(X);
        print();
    }

    private void print() {
        System.out.println(levels[O]);
        int tmp = parents[O];
        int stop = parents[X-1];
        for (int i = 0; i < x*y; i++) {
            if (tmp != -1 && tmp != stop) {
                    int d = tmp;
                tmp = parents[tmp];
                if (d == tmp - 1) {
                    maze[d / y][d % y] = ">";
                } else if (d == tmp + 1) {
                    maze[d / y][d % y] = "<";
                } else if (d == tmp + y) {
                    maze[d / y][d % y] = "^";
                } else if (d == tmp - y) {
                    maze[d / y][d % y] = "v";
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    private void breadthFirstSearch(int s) {
        List<Integer> nextLevel = new ArrayList<>();
        levels = new int[g.getN()];
        parents = new int[g.getN()];

        for(int u=0; u < g.getN(); u++) {
            levels[u] = -1;
            parents[u] = -1;
        }
        levels[s] = 0;
        nextLevel.add(s);

        while(! nextLevel.isEmpty()) {
            List<Integer> currentLevel = nextLevel;
            nextLevel = new ArrayList<>();

            for(int u : currentLevel) {
                for(int v : g.getAdjList(u)) {
                    if(levels[v] == -1) {
                        levels[v] = levels[u] + 1;
                        parents[v] = u;
                        nextLevel.add(v);
                    }
                }
            }
        }
    }

    private void read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] size = reader.readLine().split(" ");
            x = Integer.parseInt(size[0]);
            y = Integer.parseInt(size[1]);
            maze = new String[x][y];
            g = new Graph(x*y);
            for(int i = 0; i < x; i++) {
                maze[i] = reader.readLine().split("");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
