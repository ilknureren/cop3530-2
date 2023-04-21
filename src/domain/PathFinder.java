package src.domain;

import java.util.*;

public class PathFinder {
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
