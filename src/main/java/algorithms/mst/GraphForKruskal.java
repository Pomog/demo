package algorithms.mst;

import java.util.Arrays;

public class GraphForKruskal {
    int V, E;
    EdgeKruskal[] edges;

    GraphForKruskal(int V, int E) {
        this.V = V;
        this.E = E;

        edges = new EdgeKruskal[E];
        for (int i = 0; i < E; i++) {
            edges[i] = new EdgeKruskal();
        }
    }

    void kruskalAlgorithm() {
        EdgeKruskal[] edgesMST = new EdgeKruskal[V];
        Arrays.fill(edgesMST, new EdgeKruskal());
        int e = 0;

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
        }

        for (int i = 0; i < V; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

//  pick the smallest Edge
        int i = 0;
        while (e < V-1) {
            EdgeKruskal edge;
            edge = edges[i++];

//  get src and dest
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);

//  perform Union
            if (x != y) {
                edgesMST[e++] = edge;
                union(subsets, x, y);
            }
        }

        int minCost = 0;
        for (int j = 0; j < e; j++) {
            System.out.println(edgesMST[j].src + " " + edgesMST[j].dest + " : " + edgesMST[j].weight);
            minCost += edgesMST[j].weight;
        }
        System.out.println("Min cost: " + minCost);
    }

    private void union(Subset[] subsets, int x, int y) {
        if (subsets[x].rank < subsets[y].rank) {
            subsets[x].parent = y;
        } else if (subsets[y].rank < subsets[x].rank) {
            subsets[y].parent = x;
        } else {
            subsets[y].parent = x;
            subsets[x].rank++;
        }

    }

    private int find(Subset[] subsets, int elem) {
        if (subsets[elem].parent != elem) {
//  path compression
            subsets[elem].parent = find(subsets, subsets[elem].parent);
        }
        return subsets[elem].parent;
    }

    public static void main(String[] args) {
        int vertices = 8;
        int edges = 13;
        GraphForKruskal graph = new GraphForKruskal(vertices, edges);

        graph.edges[0].src = 4;
        graph.edges[0].dest = 2;
        graph.edges[0].weight = 1;

        graph.edges[1].src = 2;
        graph.edges[1].dest = 6;
        graph.edges[1].weight = 2;

        graph.edges[2].src = 2;
        graph.edges[2].dest = 7;
        graph.edges[2].weight = 9;

        graph.edges[3].src = 4;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 8;

        graph.edges[4].src = 0;
        graph.edges[4].dest = 1;
        graph.edges[4].weight = 8;

        graph.edges[5].src = 3;
        graph.edges[5].dest = 7;
        graph.edges[5].weight = 7;

        graph.edges[6].src = 0;
        graph.edges[6].dest = 5;
        graph.edges[6].weight = 4;

        graph.edges[7].src = 4;
        graph.edges[7].dest = 0;
        graph.edges[7].weight = 2;

        graph.edges[8].src = 2;
        graph.edges[8].dest = 3;
        graph.edges[8].weight = 4;

        graph.edges[9].src = 0;
        graph.edges[9].dest = 3;
        graph.edges[9].weight = 6;

        graph.edges[10].src = 2;
        graph.edges[10].dest = 1;
        graph.edges[10].weight = 10;

        graph.edges[11].src = 3;
        graph.edges[11].dest = 5;
        graph.edges[11].weight = 8;

        graph.edges[12].src = 6;
        graph.edges[12].dest = 1;
        graph.edges[12].weight = 7;

        graph.kruskalAlgorithm();
    }
}
