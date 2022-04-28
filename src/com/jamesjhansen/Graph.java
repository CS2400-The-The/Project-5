package com.jamesjhansen;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * array-based implementation of Graph ADT
 * @param <T> generically-typed
 */
public class Graph<T> implements GraphInterface<T> {

    /**
     * instance variables
     */
    private boolean[][] edges;
    private T[] labels;

    /**
     * constructor
     */
    public Graph(int n) {
        edges = new boolean[n][n];
        labels = (T[]) new Object[n];
    }

    // class methods

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

    // project methods

    // TODO: design the following two methods for the given graph...
    // The graph: {V, E} where
    // V={ A, B, C, D, E, F, G, H, I },
    // E = { (A,B), (A, D), (A, E), (B, E), (D, G), (E, F), (E, H), (G, H), (F, C), (F, H), (H, I), (C, B), (I, F) }
    // traversal to begin at node A

    /**
     * traversal: ABDEGFHCI (013465728) TODO? should we somehow display the letters instead of indices?
     * computes, displays, and returns breadth-first traversal of this graph
     * @return a queue of elements traversed in order
     */
    public Queue<Integer> breadthFirst(int start) {
        Queue<Integer> vertTraversal = new LinkedList<>();
        Queue<Integer> traversal = new LinkedList<>();
        String traversalString = "";
        boolean[] visited = new boolean[labels.length];

        visited[start] = true;
        vertTraversal.add(start);

        while (vertTraversal.size() != 0) {
            start = vertTraversal.poll();
            traversal.add(start);
            traversalString += start + ", ";

            for (Integer i : neighbors(start)) {
                if (!visited[i]) {
                    visited[i] = true;
                    vertTraversal.add(i);
                }
            }
        }
        System.out.println(traversalString);
        return traversal;
    }

    /**
     * TODO 'uses stack to expand the deepest unvisited nodes'
     * beginning at root, visits first neighbor then that node's neighbor until no further, then backtracks...
     * traversal: ABEFCHIDG (014527836) TODO? should we somehow display the letters instead of indices?
     * computes, displays, and returns depth-first traversal of this graph
     * @return a stack of elements traversed in order
     */
    public Stack<T> depthFirst(int start) {
        Stack<T> traversal = new Stack<>();

        return traversal;
    }

}
