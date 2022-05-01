package com.jamesjhansen;

/**
 * Driver class: contains main method
 */
public class Main {

    /**
     * demonstrates creation and traversal of graphs as per project requirements
     * @param args (no command line args expected for this program)
     */
    public static void main(String[] args) {

        // 1) instantiate the following graph:
        // V={ A, B, C, D, E, F, G, H, I },
        // E = { (A,B), (A, D), (A, E), (B, E), (D, G), (E, F), (E, H), (G, H), (F, C), (F, H), (H, I), (C, B), (I, F) }
        // traversal to begin at node A

        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(0,4);
        g.addEdge(1,4);
        g.addEdge(2,1);
        g.addEdge(3,6);
        g.addEdge(4,5);
        g.addEdge(4,7);
        g.addEdge(5,2);
        g.addEdge(5,7);
        g.addEdge(6,7);
        g.addEdge(7,8);
        g.addEdge(8,5);

        // 2) call breadthFirst on graph
        System.out.println("Breadth-First traversal: " + g.breadthFirst(0));

        // 3) call depthFirst on graph
        System.out.println("Depth-First traversal: " + g.depthFirst(0));

    }
}
