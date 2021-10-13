package com.company;

public class Matrixgraph {
    int[][] matrixEdge;
    int[][] matrixWeight;
    int numberOfVertices;

    public Matrixgraph(int numberOfVertices){
        this.matrixEdge=new int[numberOfVertices][numberOfVertices];
        this.matrixWeight= new int[numberOfVertices][numberOfVertices];
        this.numberOfVertices = numberOfVertices;
    }
    public void addEdge(int from, int to, int weight){
        this.matrixEdge[from][to]=1;
        this.matrixWeight[from][to]=weight;

    }
    public void printMatrixGraph(){
        for(int from=0;from< matrixEdge.length;from++){
            for(int to=0;to< matrixEdge.length; to++){
                if(matrixEdge[from][to]==1){
                    System.out.println("edge from " + from + " to " + to+ " weight " +matrixWeight[from][to]);

                }
            }
        }
    }

    public void primsMST(){
        int[] D=new int[matrixEdge.length];
        int[] P=new int[matrixEdge.length];
        MyHeap<Pair> Q = new MyHeap<>();
        Pair[] VertexPairs = new Pair[matrixEdge.length];
        for(int i=0; i< matrixEdge.length; i++){
            D[i]=Integer.MAX_VALUE;
            P[i]=-1;
            Pair newPair = new Pair(D[i],i);
            Q.insert(newPair);
            VertexPairs[i] =newPair;
        }
        if(D.length>0)
            D[0]=0;
        int pos=Q.getPosition(VertexPairs[0]);
        VertexPairs[0].distance=0;
        Q.decreasekey(pos);
        int MST =0;
        while(!Q.isEmpty()){
            Pair u= Q.extractMin();
            for (int v=0; v<numberOfVertices;){
                if(matrixEdge[u.index][v]==1 && matrixWeight[u.index][v]<D[v]){
                    D[v]=matrixWeight[u.index][v];
                    P[v]=u.index;
                    //only to get my VertixPairs updated, pos is logvtime
                    pos= Q.getPosition(VertexPairs[v]);
                    VertexPairs[v].distance= D[v];
                    Q.decreasekey(pos);
                }
            }
            MST+=D[u.index];
            System.out.println(" Edge: " + P[u.index]+"," + u.index + " Weight " + D[u.index]);
        }
        System.out.println(" MST size:"+MST);


    }

}

class Pair implements Comparable<Pair>{
    Integer distance;
    Integer index;
    public Pair(int distance, int index){
        this.distance=distance;
        this.index=index;

    }

    @Override
    public int compareTo(Pair o) {
        return distance.compareTo(o.distance);
    }

}
