package com.jamesjhansen;

/**
 * array-based implementation of Graph ADT
 * @param <T> generically-typed
 */
public class Graph<T extends Comparable<? super T>> implements GraphInterface<T> {

    /**
     * instance variables
     */
    private boolean[][] edges;
    private T[] labels;

    /**
     * constructors
     */
    public Graph(int n) {
        edges = new boolean[n][n];
        labels = (T[]) new Object[n];
    }

    /**
     * returns label given vertex
     * @param vertex integer index of vertex
     * @return the label associated with the vertex passed
     */
    @Override
    public T getLabel(int vertex) {
        return labels[vertex];
    }

    /**
     * determines whether there is an edge that connects source to target
     * @param source integer index of source vertex
     * @param target integer index of target vertex
     * @return true if source and target are connected by an edge, false otherwise
     */
    @Override
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    /**
     * adds connection to graph given existing source and target vertices
     * @param source integer index of source vertex
     * @param target integer index of target vertex
     */
    @Override
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    /**
     * returns neighbors of given vertex
     * @param vertex integer index of given vertex
     * @return integer array of neighbors to given vertex
     */
    @Override
    public int[] neighbors(int vertex) {
        int i;
        int count = 0;
        int[] answer;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                count++;
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }

    /**
     * removes edge from graph
     * @param source integer index of source vertex
     * @param target integer index of target vertex
     */
    @Override
    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }

    /**
     * associates label with given vertex
     * @param vertex integer array of vertex to set label for
     * @param newLabel the new value for label set
     */
    @Override
    public void setLabel(int vertex, T newLabel) {
        labels[vertex] = newLabel;
    }

    /**
     * returns size of graph
     * @return integer count of total number of vertices in graph
     */
    @Override
    public int size() {
        return labels.length;
    }
}
