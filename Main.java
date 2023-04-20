import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        City sanFrancisco = new City("San Francisco", 37, -122);
        City newYork = new City("New York", 34, -118);
        City chicago = new City("Chicago", 20, -20);
        City losAngeles = new City("Los Angeles", 14, -300);
        City miami = new City("Miami", 50, -250);
        graph.addCity(sanFrancisco);
        graph.addCity(newYork);
        graph.addCity(chicago);
        graph.addCity(losAngeles);
        graph.addCity(miami);
        graph.addEdge(new Edge(sanFrancisco, newYork, 383));
        graph.addEdge(new Edge(sanFrancisco, chicago, 2112));
        graph.addEdge(new Edge(losAngeles, chicago, 2015));
        graph.addEdge(new Edge(newYork, chicago, 790));
        graph.addEdge(new Edge(newYork, miami, 1306));
        graph.addEdge(new Edge(losAngeles, miami, 2786));

        ArrayList<City> path = PathFinder.findShortestPath(graph, sanFrancisco, miami);
        System.out.println("Shortest path from " + sanFrancisco.getName() + " to " + miami.getName() + ":");
        for (City city : path) {
            System.out.println(city.getName());
        }
    }
}
class City {
    private String name;
    private int latitude;
    private int longitude;

    public City(String name, int latitude, int longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}

class Edge {
    private City source;
    private City destination;
    private int weight;

    public Edge(City source, City destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public City getSource() {
        return source;
    }

    public City getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}

class Graph {
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

class PathFinder {
    public PathFinder(CityGraph cityGraph) {
    }

    public static ArrayList<City> findShortestPath(Graph graph, City source, City destination) {
        Map<City, Integer> distance = new HashMap<>();
        Map<City, City> previous = new HashMap<>();
        PriorityQueue<City> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        Set<City> visited = new HashSet<>();

        distance.put(source, 0);
        queue.add(source);

        while (!queue.isEmpty()) {
            City current = queue.poll();
            if (current == destination) {
                break;
            }

            visited.add(current);
            List<Edge> edges = graph.getEdges(current);

            for (Edge edge : edges) {
                City next = edge.getDestination();
                int weight = edge.getWeight();
                int newDistance = distance.get(current) + weight;

                if (!visited.contains(next) && (!distance.containsKey(next) || newDistance < distance.get(next))) {
                    distance.put(next, newDistance);
                    previous.put(next, current);
                    queue.add(next);
                }
            }
        }

        ArrayList<City> path = new ArrayList<>();
        City current = destination;

        while (previous.containsKey(current)) {
            path.add(current);
            current = previous.get(current);
        }

        path.add(source);
        Collections.reverse(path);

        return path;
    }

    public List<String> findPath(String startCity, String endCity) {
        return null;
    }
}
