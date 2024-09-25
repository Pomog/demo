package algorithms.mst;

import java.util.Arrays;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, 0, 0, 8},
                {3, 0, 4, 2, 0},
                {0, 4, 0, 10, 0},
                {0, 2, 10, 11, 0},
                {8, 0, 0, 11, 0}
        };

        getMST(graph);
    }

    private static void getMST(int[][] graph) {
        int length = graph.length;

        boolean[] selected = new boolean[length];
        Arrays.fill(selected, false);

        selected[0] = true;

        int edges = 0;

        while (edges < length - 1) {
            int min = Integer.MAX_VALUE;
            int x = 0, y = 0;

            for (int i = 0; i < length; i++) {
                if (selected[i]) {
                    for (int j = 0; j < length; j++) {
                        if (!selected[j] && graph[i][j] != 0) {
                            if (min > graph[i][j]) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " : " + graph[x][y]);
            selected[y] = true;
            edges++;
        }
    }
}
