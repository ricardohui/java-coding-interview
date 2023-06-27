package com.ricardohui.javaCodingInterview.graph;

class CheckCycle {
    public static boolean detectCycle(Graph g){
        int numOfVertices = g.getVertices();

        boolean[] visited = new boolean[numOfVertices];
        boolean[] stackFlag = new boolean[numOfVertices];

        for (int i = 0; i < numOfVertices; i++) {
            if(dfs(g, i, visited, stackFlag)) return true;
        }

        return false;
    }

    public static boolean dfs(Graph graph, int source, boolean[] visited, boolean[] stackFlag){
        DoublyLinkedList<Integer>.Node childNode = graph.adjacencyList[source].headNode;

        if (stackFlag[source]){
            return true;
        }

        if(visited[source]){
            return false;
        }

        visited[source] = true;
        stackFlag[source] = true;

        while (childNode != null) {
            if ( dfs(graph, childNode.data, visited, stackFlag)){
                return true;
            }

            childNode = childNode.nextNode;
        }
        stackFlag[source] = false;
        return false;
    }


    public static void main(String args[]) {
        Graph g1 = new DirectedGraph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new DirectedGraph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }
}