package src.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<City, List<Edge>> graph = new HashMap<>();

    public void addCity(City city) {
        graph.put(city, new ArrayList<>());
    }

    public void addEdge(Edge edge) {
        City source = edge.getSource();
        graph.get(source).add(edge);
    }

    public List<Edge> getEdges(City city) {
        return graph.get(city);
    }
}
