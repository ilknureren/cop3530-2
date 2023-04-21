package src;

import src.domain.City;
import src.domain.Edge;
import src.domain.Graph;
import src.domain.PathFinder;

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


