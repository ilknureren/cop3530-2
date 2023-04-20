import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityGraph {
    private Map<String, List<String>> adjacencyList;

    public CityGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public List<String> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public List<String> getNeighbors(String vertex) {
        return new ArrayList<>(adjacencyList.get(vertex));
    }
}
