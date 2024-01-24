package algorithms.dfs;

import algorithms.Vertex;

import java.util.List;

public class TreeRooter<T> {
    private Integer rootIndex;
    private List<Vertex<T>> graph;

    public TreeRooter(Integer rootIndex, List<Vertex<T>> graph) {
        this.rootIndex = rootIndex;
        this.graph = graph;
    }

    public Vertex<T> GetRootNode (){
        // clearing parents for root node
        graph.get(rootIndex).getParents().clear();
        return buildTree (graph, this.rootIndex, null);
    }

    private Vertex<T> buildTree (List<Vertex<T>> graph, Integer currentNodeIndex, Vertex<T> parentNode){
        for (Vertex<T> childNode : graph.get(currentNodeIndex).getNeighbors()){

            // Avoid adding an edge pointing back to the parent
            if (parentNode != null && childNode == parentNode || (parentNode != null && childNode.isVisited()) && parentNode.isVisited()){
                continue;
            }

            childNode.setVisited(true);

            if (!graph.get(currentNodeIndex).getChildren().contains(childNode)) {
                graph.get(currentNodeIndex).getChildren().add(childNode);
            }

            if (!childNode.getParents().contains(graph.get(currentNodeIndex))) {
                childNode.getParents().add(graph.get(currentNodeIndex));
            }

            Integer childNodeIndex = graph.indexOf(childNode);

            buildTree(graph, childNodeIndex, graph.get(currentNodeIndex));
        }
        return graph.get(currentNodeIndex);
    }
}
