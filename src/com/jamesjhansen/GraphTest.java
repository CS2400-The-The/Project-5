package com.jamesjhansen;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 * contains unit tests for methods in Graph class
 * 
 * 1. 3x3 graph
 * 
 * 2. Empty Graph
 * 
 * 3. 2x2 graph, one unconnected node
 * 
 * 4. 2x2 graph, nothing connected
 * 
 * 5. 3x3 graph, only once connecting path
 * 
 * 6. 2x2 graph, one with a cycle
 */
public class GraphTest {
    
    //3x3 Random Graph
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

    //2x2 graph, 3 nodes connecting and one disconnected
    public static void graph3(Graph graph1) {

        graph1.setLabel(0, "A");
        graph1.setLabel(1, "B");
        graph1.setLabel(2, "C");
        graph1.setLabel(3, "D");

        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);


    }

    //2x2 graph, nothing connected
    public static void graph4(Graph graph1) {

        graph1.setLabel(0, "A");
        graph1.setLabel(1, "B");
        graph1.setLabel(2, "C");
        graph1.setLabel(3, "D");

    }

    //3x3 Graph with one connecting line
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

    //2x2 graph, full cycle
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
    

    /**
     * handles any setup required prior to testing
     * @throws Exception
     */
    @Before
    protected void setUp() throws Exception {

    }

    @Test
    void breadthFirst() {

        //Test 1
        Graph testGraph1 = new Graph(9);
        graph1(testGraph1);

        String first = "A E G I D H B C F ";
        String sixth = "A E G I D H C B F ";
        String seventh = "A E G I H D B C F ";
        String eighth = "A E G I H D C B F ";
        String second = "A G E D H I B C F ";
        String third = "A G E H D I B C F ";
        String fourth = "A G E D H I C B F ";
        String fifth = "A G E H D I C B F ";

        System.out.println("Test 1: Graph with traversals starting at A");
        System.out.println("All possible Breadth First Traversals: \n" +
        first + "\n" + sixth + "\n" + seventh + "\n" + eighth + "\n" + second + "\n" + third
        + "\n" + fourth + "\n" + fifth + "\n");

        String resultant1 = testGraph1.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant1);
        assertTrue(resultant1.equals(first));

        //Test 2
        /*Graph testGraph2 = new Graph2(4);
        graph2(testGraph2);

        String first2 = "";
        System.out.println("Test 2: Empty Graph");
        System.out.println("All possible Breadth First Traversals: \n" +
        first2);

        String resultant2 = testGraph2.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant1);
        assertTrue(resultant2.equals(first2));
        */

        //Test 3
        Graph testGraph3 = new Graph(4);
        graph3(testGraph3);

        String first3 = "A B C ";
        String second3 = "A C B ";

        System.out.println("Test 3: Graph with traversals starting at A and one unconnected node");
        System.out.println("All possible Breadth First Traversals: \n" +
        first3 + "\n" + second3);

        String resultant3 = testGraph3.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant3);
        assertTrue(resultant3.equals(first3));

        //Test 4
        Graph testGraph4 = new Graph(4);
        graph4(testGraph4);

        String first4 = "A ";

        System.out.println("Test 4: Graph with four nodes but nothing connected");
        System.out.println("All possible Breadth First Traversals: \n" +
        first4);

        String resultant4 = testGraph4.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant4 +"\n");
        assertTrue(resultant4.equals(first4));

        //Test 5
        Graph testGraph5 = new Graph(9);
        graph5(testGraph5);

        String first5 = "A B C D E F G H I ";

        System.out.println("Test 5: Graph with 9 nodes but only one correct path");
        System.out.println("All possible Breadth First Traversals: \n" +
        first5);

        String resultant5 = testGraph5.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant5 +"\n");
        assertTrue(resultant5.equals(first5));

        //Test 6
        Graph testGraph6 = new Graph(4);
        graph6(testGraph6);

        String first6 = "A B C D ";

        System.out.println("Test 6: Graph with 4 nodes but one full cycle");
        System.out.println("All possible Breadth First Traversals: \n" +
        first6);

        String resultant6 = testGraph6.breadthFirst(0);
        System.out.println("Resulting traversal order: " + resultant6 +"\n");
        assertTrue(resultant6.equals(first6));



    }
    @Test
    void depthFirst() {

        String first = "A E I B H C F G D ";
        String second = "A E I C F B H G D ";
        String third = "A E I C B H F G D ";
        String fourth = "A G D I B H C F E ";
        String fifth = "A G D I C F E B H ";
        String sixth = "A G D I C B H F E ";
        String seventh = "A G D H I B C F E ";
        String eight = "A G D H I C F E B ";
        String ninth = "A G D H I C B F E ";
        String tenth = "A G I B H C F E D ";
        String eleventh = "A G I C F E B H D ";
        String twelfth = "A G I C B H F E D ";
        String thirteenth = "A G H I B C F E D ";
        String fourteenth = "A G H I C B F E D ";
        String fifteenth = "A G H I C F E B D ";
        String sixteenth = "A G H D I B C F E ";
        String seventeenth = "A G H D I C B F E ";
        String eighteenth = "A G H D I C F E B ";

        Graph testGraph1 = new Graph(9);
        graph1(testGraph1);
        System.out.println("Test 1: Graph with traversals starting at A");
        System.out.println("All possible Depth First Traversals: \n" + 
        first + "\n" + second + "\n" + third + "\n" + fourth + "\n" +
        fifth + "\n" + sixth + "\n" + seventh + "\n" + eight + "\n" +
        ninth + "\n" + tenth + "\n" + eleventh + "\n" + twelfth + "\n" +
        thirteenth + "\n" + fourteenth + "\n" + fifteenth + "\n" + sixteenth +
        "\n" + seventeenth + "\n" + eighteenth + "\n");

        String resultant1 = testGraph1.depthFirst(0);
        System.out.println("Resulting traversal order: " + resultant1);
        assertTrue(resultant1.equals(eleventh));


    }

    



}
