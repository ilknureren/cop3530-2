import java.util.*;

public class PathFinder {
    private CityGraph cityGraph;

    public PathFinder(CityGraph cityGraph) {
        this.cityGraph = cityGraph;
    }

    public List<String> findPath(String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parents = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) {
                return getPath(parents, start, end);
            }

            for (String neighbor : cityGraph.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parents.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        return null;
    }

    private List<String> getPath(Map<String, String> parents, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;
        while (!current.equals(start)) {
            path.add(0, current);
            current = parents.get(current);
        }
        path.add(0, start);
        return path;
    }
}
