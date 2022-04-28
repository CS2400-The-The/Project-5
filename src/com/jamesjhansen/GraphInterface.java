package com.jamesjhansen;

/**
 * generically-typed interface for Graph ADT
 */
public interface GraphInterface<T> {

    public T getLabel(int vertex);
    public boolean isEdge(int source, int target);
    public void addEdge(int source, int target);
    public int[] neighbors(int vertex);
    public void removeEdge(int source, int target);
    public void setLabel(int vertex, T newLabel);
    public int size();
}
