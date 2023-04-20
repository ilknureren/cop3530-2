import java.util.*;

public class Main {
    public static void main(String[] args) {
        CityPathGraph cityGraph = new CityPathGraph();
        cityGraph.addCity("New York");
        cityGraph.addCity("Chicago");
        cityGraph.addCity("San Francisco");
        cityGraph.addCity("Los Angeles");
        cityGraph.addConnection("New York", "Chicago");
        cityGraph.addConnection("New York", "San Francisco");
        cityGraph.addConnection("Chicago", "Los Angeles");
        cityGraph.addConnection("San Francisco", "Los Angeles");
        List<String> path = cityGraph.getPath("New York", "Los Angeles");
        if (path == null) {
            System.out.println("No path found.");
        } else {
            System.out.println("Path: " + path);
        }
    }
}
