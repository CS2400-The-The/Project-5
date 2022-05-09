package com.jamesjhansen;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 * contains unit tests for methods in Graph class
 * 
 * 1. Random 9 node Graph
 * 
 * 2. 4 vertices graph, everything is adjacent to everything 
 * 
 * 3. 4 vertices graph, one unconnected node
 * 
 * 4. 4 vertices graph, nothing connected
 * 
 * 5. 9 vertices graph, only once connecting path
 * 
 * 6. 4 vertices graph, one with a cycle
 * 
 */
public class GraphTest {
    
    //Random 9 vertices graph
    public static void graph1(Graph graph1) {

        graph1.setLabel(0, "A");
        graph1.setLabel(1, "B");
        graph1.setLabel(2, "C");
        graph1.setLabel(3, "D");
        graph1.setLabel(4, "E");
        graph1.setLabel(5, "F");
        graph1.setLabel(6, "G");
        graph1.setLabel(7, "H");
        graph1.setLabel(8, "I");

        graph1.addEdge(0, 6);
        graph1.addEdge(0, 4);
        graph1.addEdge(1, 7);
        graph1.addEdge(2, 1);
        graph1.addEdge(2, 5);
        graph1.addEdge(4, 8);
        graph1.addEdge(5, 4);
        graph1.addEdge(6, 7);
        graph1.addEdge(6, 3);
        graph1.addEdge(6, 8);
        graph1.addEdge(8, 1);
        graph1.addEdge(8, 2);

    }

    //5 Vertices graph, everything is connectecd to everything 
    public static void graph2(Graph graph1) {

        graph1.setLabel(0, "A");
        graph1.setLabel(1, "B");
        graph1.setLabel(2, "C");
        graph1.setLabel(3, "D");


        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(0, 3);

        graph1.addEdge(1, 0);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);

        graph1.addEdge(2, 0);
        graph1.addEdge(2, 1);
        graph1.addEdge(2, 3);

        graph1.addEdge(3, 0);
        graph1.addEdge(3, 1);
        graph1.addEdge(3, 2);


    }

    //4 vertices graph, 3 nodes connecting and one disconnected
    public static void graph3(Graph graph1) {

        graph1.setLabel(0, "A");
        graph1.setLabel(1, "B");
        graph1.setLabel(2, "C");
        graph1.setLabel(3, "D");

        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);


    }

    //4 Vertices, nothing connected
    public static void graph4(Graph graph1) {

        graph1.setLabel(0, "A");
        graph1.setLabel(1, "B");
        graph1.setLabel(2, "C");
        graph1.setLabel(3, "D");

    }

    //9 vertices with one connecting line
    public static void graph5(Graph graph1) {

        graph1.setLabel(0, "A");
        graph1.setLabel(1, "B");
        graph1.setLabel(2, "C");
        graph1.setLabel(3, "D");
        graph1.setLabel(4, "E");
        graph1.setLabel(5, "F");
        graph1.setLabel(6, "G");
        graph1.setLabel(7, "H");
        graph1.setLabel(8, "I");

        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        graph1.addEdge(4, 5);
        graph1.addEdge(5, 6);
        graph1.addEdge(6, 7);
        graph1.addEdge(7, 8);

    }

    //4 vertices, full cycle
    public static void graph6(Graph graph1) {

        graph1.setLabel(0, "A");
        graph1.setLabel(1, "B");
        graph1.setLabel(2, "C");
        graph1.setLabel(3, "D");

        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 0);


    }

    //Empty Graph Will be initialized but not setup


    @Test
    void breadthFirst() {

        //Test 1
        Graph testGraph1 = new Graph(9);
        graph1(testGraph1);

        String expected1 = "A E G I D H B C F ";

        System.out.println("Test 1: Random 9 node graph");
        System.out.println("Expected breadth traversal: " + expected1);

        String resultant1 = testGraph1.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant1);
        System.out.println();
        assertTrue(resultant1.equals(expected1));

        //Test 2
        Graph testGraph2 = new Graph(5);
        graph2(testGraph2);

        String expected2 = "A B C D ";
        System.out.println("Test 2: 4 vertices, everything connected");
        System.out.println("Expected breadth  traversal: " + expected2);
        System.out.println("Graph image:\n" +
                           "A     ==    B      \n" +
                           "||    \\\\   ||       \n" +
                           "C     ==    D       ");

        String resultant2 = testGraph2.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant2);
        System.out.println();
        assertTrue(resultant2.equals(expected2));

        //Test 3
        Graph testGraph3 = new Graph(4);
        graph3(testGraph3);

        String expected3 = "A B C ";

        System.out.println("Test 3: 4 Vertices Graph with traversals starting at A and one unconnected node");
        System.out.println("Expected breadth  Traversal: " + expected3);
        System.out.println("Graph Image:\n" + 
                           "A -> B -> C  D");


        String resultant3 = testGraph3.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant3);
        System.out.println();
        assertTrue(resultant3.equals(expected3));

        //Test 4
        Graph testGraph4 = new Graph(4);
        graph4(testGraph4);

        String expected4 = "A "; 

        System.out.println("Test 4: Graph with four vertices but nothing connected");
        System.out.println("Expected breadth  Traversal: " + expected4);
        System.out.println("Graph Image:\n" + 
                           "A   B       \n" +
                           "            \n" +
                           "C   D         ");

        String resultant4 = testGraph4.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant4);
        System.out.println();
        assertTrue(resultant4.equals(expected4));

        //Test 5
        Graph testGraph5 = new Graph(9);
        graph5(testGraph5);

        String expected5 = "A B C D E F G H I ";

        System.out.println("Test 5: Graph with 9 vertices but only one correct path");
        System.out.println("Expected breadth  Traversal: " + expected5);
        System.out.println("Graph Image:\n" + 
                           "A -> B -> C \n" +
                           "          | \n" +
                           "          V \n" +
                           "F <- E <- D \n" +
                           "|           \n" +
                           "V           \n" +
                           "G -> H -> I \n");

        String resultant5 = testGraph5.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant5 +"\n");
        assertTrue(resultant5.equals(expected5));

        //Test 6
        Graph testGraph6 = new Graph(4);
        graph6(testGraph6);

        String expected6 = "A B C D ";

        System.out.println("Test 6: Graph with 4 vertices but one full cycle");
        System.out.println("Expected breadth  Traversal: " + expected6);
        System.out.println("Graph Image:\n" + 
                           "A -> B \n" +
                           "^    | \n" +
                           "|    V \n" +
                           "D <- C");

        String resultant6 = testGraph6.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant6 +"\n");
        assertTrue(resultant6.equals(expected6));



    }
    @Test
    void depthFirst() {

        //Test 1
        Graph testGraph1 = new Graph(9);
        graph1(testGraph1);

        String expected1 = "A E I B H C F G D ";

        System.out.println("Test 1: Random 9 node graph");
        System.out.println("Expected depth traversal: " + expected1);

        String resultant1 = testGraph1.depthFirst(0);
        System.out.println("Resulting traversal order: " + resultant1);
        System.out.println();
        assertTrue(resultant1.equals(expected1));

        //Test 2
        Graph testGraph2 = new Graph(5);
        graph2(testGraph2);

        String expected2 = "A B C D ";
        System.out.println("Test 2: 4 vertices, everything connected");
        System.out.println("Expected depth traversal: " + expected2);
        System.out.println("Graph image:\n" +
                           "A     ==    B      \n" +
                           "||    \\\\   ||       \n" +
                           "C     ==    D       ");

        String resultant2 = testGraph2.depthFirst(0);
        System.out.println("Resulting traversal order: " + resultant2);
        System.out.println();
        assertTrue(resultant2.equals(expected2));

        //Test 3
        Graph testGraph3 = new Graph(4);
        graph3(testGraph3);

        String expected3 = "A B C ";

        System.out.println("Test 3: 4 Vertices Graph with traversals starting at A and one unconnected node");
        System.out.println("Expected depth Traversal: " + expected3);
        System.out.println("Graph Image:\n" + 
                           "A -> B -> C  D");


        String resultant3 = testGraph3.depthFirst(0);
        System.out.println("Resulting traversal order: " + resultant3);
        System.out.println();
        assertTrue(resultant3.equals(expected3));

        //Test 4
        Graph testGraph4 = new Graph(4);
        graph4(testGraph4);

        String expected4 = "A "; 

        System.out.println("Test 4: Graph with four vertices but nothing connected");
        System.out.println("Expected depth Traversal: " + expected4);
        System.out.println("Graph Image:\n" + 
                           "A   B       \n" +
                           "            \n" +
                           "C   D         ");

        String resultant4 = testGraph4.depthFirst(0);
        System.out.println("Resulting traversal order: " + resultant4);
        System.out.println();
        assertTrue(resultant4.equals(expected4));

        //Test 5
        Graph testGraph5 = new Graph(9);
        graph5(testGraph5);

        String expected5 = "A B C D E F G H I ";

        System.out.println("Test 5: Graph with 9 vertices but only one correct path");
        System.out.println("Expected depth Traversal: " + expected5);
        System.out.println("Graph Image:\n" + 
                           "A -> B -> C \n" +
                           "          | \n" +
                           "          V \n" +
                           "F <- E <- D \n" +
                           "|           \n" +
                           "V           \n" +
                           "G -> H -> I \n");

        String resultant5 = testGraph5.depthFirst(0);
        System.out.println("Resulting traversal order: " + resultant5 +"\n");
        assertTrue(resultant5.equals(expected5));

        //Test 6
        Graph testGraph6 = new Graph(4);
        graph6(testGraph6);

        String expected6 = "A B C D ";

        System.out.println("Test 6: Graph with 4 vertices but one full cycle");
        System.out.println("Expected depthTraversal: " + expected6);
        System.out.println("Graph Image:\n" + 
                           "A -> B \n" +
                           "^    | \n" +
                           "|    V \n" +
                           "D <- C");

        String resultant6 = testGraph6.depthFirst(0);
        System.out.println("Resulting traversal order: " + resultant6 +"\n");
        assertTrue(resultant6.equals(expected6));


    }

    



}
