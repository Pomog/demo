package algorithms.named;

import algorithms.named.base.Vertex;
import algorithms.named.base.Edge;
import algorithms.named.fordFulkerson.FordFulkerson;

import java.util.*;

public class Ford_Fulkerson_Generic {
    public static void main(String[] args) {
        Vertex<String> source = new Vertex<>(0, "Source");
        Vertex<String> v1 = new Vertex<>(1, "V1");
        Vertex<String> v2 = new Vertex<>(2, "V2");
        Vertex<String> v3 = new Vertex<>(3, "V3");
        Vertex<String> v4 = new Vertex<>(4, "V4");
        Vertex<String> sink = new Vertex<>(5, "Sink");
        
        Edge<String> edgeSourceToV1 = new Edge<>(source, v1);
        edgeSourceToV1.setCapacity(3);
        
        Edge<String> edgeSourceToV2 = new Edge<>(source, v2);
        edgeSourceToV2.setCapacity(2);
        
        Edge<String> edgeV1ToV3 = new Edge<>(v1, v3);
        edgeV1ToV3.setCapacity(2);
        
        Edge<String> edgeV2ToV1 = new Edge<>(v2, v1);
        edgeV2ToV1.setCapacity(3);
        
        Edge<String> edgeV2ToV4 = new Edge<>(v2, v4);
        edgeV2ToV4.setCapacity(3);
        
        Edge<String> edgeV3ToV2 = new Edge<>(v3, v2);
        edgeV3ToV2.setCapacity(1);
        
        Edge<String> edgeV3ToSink = new Edge<>(v3, sink);
        edgeV3ToSink.setCapacity(3);
        
        Edge<String> edgeV4ToSink = new Edge<>(v4, sink);
        edgeV4ToSink.setCapacity(2);
        
        Map<Vertex<String>, List<Edge<String>>> graph = new HashMap<>();
        graph.put(source, new ArrayList<>(List.of(edgeSourceToV1, edgeSourceToV2)));
        graph.put(v1, new ArrayList<>(List.of(edgeV1ToV3)));
        graph.put(v2, new ArrayList<>(List.of(edgeV2ToV1, edgeV2ToV4)));
        graph.put(v3, new ArrayList<>(List.of(edgeV3ToV2, edgeV3ToSink)));
        graph.put(v4, new ArrayList<>(List.of(edgeV4ToSink)));
        graph.put(sink, new ArrayList<>());
        
        FordFulkerson<String> fordFulkerson = new FordFulkerson<>(graph);
        System.out.println(fordFulkerson.findMaxFlow(source,sink));
    }
}
