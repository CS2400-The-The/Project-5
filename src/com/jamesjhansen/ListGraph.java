package com.jamesjhansen;

import java.util.ArrayList;
import java.util.Objects;

/**
 * list-based implementation of Graph ADT
 * @param <T> generically-typed
 */
public class ListGraph<T extends Comparable<? super T>> implements GraphInterface<T> {

    /**
     * instance variables
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    private ArrayList<Boolean>[] edges = new ArrayList[DEFAULT_INITIAL_CAPACITY];
    private ArrayList<T> labels;

    /**
     * constructors
     */
    public ListGraph(int n) {
        for (int i=0; i<DEFAULT_INITIAL_CAPACITY; i++) {
            edges[i] = new ArrayList<>();
        }
        labels = new ArrayList<>();
    }

    /**
     * returns label given vertex
     * @param vertex integer index of vertex
     * @return the label associated with the vertex passed
     */
    @Override
    public T getLabel(int vertex) {
        return labels.get(vertex);
    }

    /**
     * determines whether there is an edge that connects source to target
     * @param source integer index of source vertex
     * @param target integer index of target vertex
     * @return true if source and target are connected by an edge, false otherwise
     */
    @Override
    public boolean isEdge(int source, int target) {
        return edges[source].get(target);
    }

    /**
     * adds connection to graph given existing source and target vertices
     * @param source integer index of source vertex
     * @param target integer index of target vertex
     */
    @Override
    public void addEdge(int source, int target) {
        edges[source].add(target, true);
    }

    /**
     * returns neighbors of given vertex
     * @param vertex integer index of given vertex
     * @return integer array of neighbors to given vertex
     * note: return type is primitive array to remain consistent with interface
     */
    @Override
    public int[] neighbors(int vertex) {
        int i;
        int count = 0;
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (i = 0; i < labels.size(); i++) {
            if (edges[vertex].get(i))
                neighbors.add(i);
        }
        // if not for the interface restriction, we'd simply return an arraylist
        // instead we map our arraylist to a primitive array, ensuring null values are filtered
        int[] result = neighbors.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
        return result;
    }

    /**
     * removes edge from graph
     * @param source integer index of source vertex
     * @param target integer index of target vertex
     */
    @Override
    public void removeEdge(int source, int target) {
        edges[source].set(target, false);
    }

    /**
     * associates label with given vertex
     * @param vertex integer array of vertex to set label for
     * @param newLabel the new value for label set
     */
    @Override
    public void setLabel(int vertex, T newLabel) {
        labels.set(vertex, newLabel);
    }

    /**
     * returns size of graph
     * @return integer count of total number of vertices in graph
     */
    @Override
    public int size() {
        return labels.size();
    }
}
