package com.jamesjhansen;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;

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

    /**
     * computes, displays, and returns breadth-first traversal of this graph
     * traversal: ABDEGFHCI (013465728) TODO? should we somehow display the letters instead of indices?
     * @return a queue of elements traversed in order
     */
    public String breadthFirst(int start) {
        Queue<Integer> vertTraversal = new LinkedList<>();
        String traversalString = "";
        boolean[] visited = new boolean[labels.length];

        visited[start] = true;
        vertTraversal.add(start);

        while (vertTraversal.size() != 0) {
            start = vertTraversal.poll();
            traversalString += start + " ";

            for (Integer i : neighbors(start)) {
                if (!visited[i]) {
                    visited[i] = true;
                    vertTraversal.add(i);
                }
            }
        }
        return traversalString;
    }

    /**
     * computes, displays, and returns depth-first traversal of this graph
     * traversal: AEHIFCBDG (047852136) TODO? should we somehow display the letters instead of indices?
     * @return a stack of elements traversed in order
     */
    public String depthFirst(int start) {
        Stack<Integer> vertTraversal = new Stack<>();
        String traversalString = "";
        boolean[] visited = new boolean[labels.length];

        vertTraversal.push(start);

        while (!vertTraversal.empty()) {
            start = vertTraversal.peek();
            vertTraversal.pop();

            if (!visited[start]) {
                traversalString += start + " ";
                visited[start] = true;
            }

            for (Integer i : neighbors(start)) {
                if (!visited[i])
                    vertTraversal.push(i);
            }
        }
        return traversalString;
    }

    public String depthFirst2(int start) {
        Stack<Integer> vertexStack = new Stack<>();
        String traversalOrder = "";
        boolean[] visited = new boolean[labels.length];   

        visited[start] = true;
        vertexStack.push(start);
        traversalOrder += this.getLabel(start) + " ";


        while (!vertexStack.isEmpty()) {
            
            int topVertex = vertexStack.peek();            //vertex at top of the stack
            int[] neighbors = this.neighbors(topVertex);   //array of topvertex's neighbors
            Arrays.sort(neighbors);                        //sort for alphabetical order 

            for (int i = 0; i < neighbors.length; i++) {
                if (!visited[neighbors[i]]) {
                    visited[neighbors[i]] = true;
                    vertexStack.push(neighbors[i]);
                    traversalOrder += this.getLabel(neighbors[i]) + " ";
                    break;
                } else {
                    vertexStack.pop();
                }
            }
        }
        return traversalOrder;

    } //end depthFirst2


}
