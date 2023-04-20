import java.util.List;

public class CityPathGraph {
    private CityGraph cityGraph;

    public CityPathGraph() {
        cityGraph = new CityGraph();
    }

    public void addCity(String city) {
        cityGraph.addVertex(city);
    }

    public void addConnection(String city1, String city2) {
        cityGraph.addEdge(city1, city2);
    }

    public List<String> getPath(String startCity, String endCity) {
        PathFinder pathFinder = new PathFinder(cityGraph);
        return pathFinder.findPath(startCity, endCity);
    }
}
