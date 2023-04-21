package src.domain;

public class Edge {
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

