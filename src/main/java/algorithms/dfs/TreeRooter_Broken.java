package algorithms.dfs;

import algorithms.Vertex;

import java.util.ArrayList;
import java.util.List;

public class TreeRooter_Broken<T> {
    private Integer rootIndex;
    private List<Vertex<T>> graph;
    private List<List<Vertex<T>>> paths = new ArrayList<>();

    public TreeRooter_Broken(Integer rootIndex, List<Vertex<T>> graph) {
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
            List<Vertex<T>> currentPath = new ArrayList<>() {{
                add(graph.get(currentNodeIndex));
                add(childNode);
            }};
            System.out.println("Now is: " + graph.get(currentNodeIndex) + " ---> " + childNode);

            // Avoid adding an edge pointing back to the parent
            if (parentNode != null && childNode == parentNode)
             {
                 System.out.println("Not included - parentNode");
                continue;
            }
            if (paths.contains(currentPath)){
                System.out.println("Not included - PATH exist");
                continue;
            }
            System.out.println(paths);

            paths.add(currentPath);

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
