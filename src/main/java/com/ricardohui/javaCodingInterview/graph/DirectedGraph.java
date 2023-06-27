package com.ricardohui.javaCodingInterview.graph;

class DirectedGraph extends Graph {

    public DirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);
        }
    }

    @Override
    public void removeEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            DoublyLinkedList<Integer>.Node childNode = this.adjacencyList[source].headNode;
            DoublyLinkedList<Integer>.Node parent = null;
            while (childNode != null) {
                if (childNode.data == destination) {
                    if (parent != null){
                        parent.nextNode = childNode.nextNode;
                    }else{
                        this.adjacencyList[source].headNode = childNode.nextNode;
                    }
                    break;
                }
                parent = childNode;
                childNode = childNode.nextNode;
            }
        }
    }

    public int count(){
        return this.vertices;
    }



}
