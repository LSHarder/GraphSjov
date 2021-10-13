package com.company;

public class Main {

    public static void main(String[] args) {
	    Matrixgraph myGraph1= new Matrixgraph(7);
        myGraph1.addEdge(0,1,1);
        myGraph1.addEdge(0,2,5);
        myGraph1.addEdge(0,4,3);
        myGraph1.addEdge(1,4,1);
        myGraph1.addEdge(1,5,7);
        myGraph1.addEdge(2,3,1);
        myGraph1.addEdge(3,4,1);
        myGraph1.addEdge(3,6,1);
        myGraph1.addEdge(4,2,1);
        myGraph1.addEdge(4,3,3);
        myGraph1.addEdge(4,5,3);
        myGraph1.addEdge(4,6,4);
        myGraph1.addEdge(5,6,1);
    }
}
