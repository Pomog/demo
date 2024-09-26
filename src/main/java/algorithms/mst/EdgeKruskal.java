package algorithms.mst;

public class EdgeKruskal implements Comparable<EdgeKruskal> {
    int src, dest, weight;

    @Override
    public int compareTo(EdgeKruskal o) {
        return this.weight - o.weight;
    }
}
