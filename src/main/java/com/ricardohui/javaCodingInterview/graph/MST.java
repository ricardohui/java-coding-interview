package com.ricardohui.javaCodingInterview.graph;


import java.util.*;

class MST {

    static Graph findMinSpanningTree(Graph graph) {
        Graph mst = new Graph(new ArrayList<>(), new ArrayList<>());
        PriorityQueue<Edge> sortedEdges = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        sortedEdges.addAll(graph.e);

        for (Edge sortedEdge : sortedEdges) {
            if (!sortedEdge.src.visited || !sortedEdge.dest.visited) {
                sortedEdge.visited = true;
//                if (!sortedEdge.src.visited) {
                    sortedEdge.src.visited = true;
                    mst.v.add(sortedEdge.src);
//                }
//                if (!sortedEdge.dest.visited) {
                    sortedEdge.dest.visited = true;
                    mst.v.add(sortedEdge.dest);
//                }
                mst.e.add(sortedEdge);
            }
        }

        return mst;
    }

    static class Vertex {
        public int id;
        public boolean visited;

        public Vertex(int id, boolean visited) {
            this.id = id;
            this.visited = visited;
        }
    }

    static class Edge {
        public int weight;
        public boolean visited;
        public Vertex src;
        public Vertex dest;

        public Edge(int weight, boolean visited, Vertex src, Vertex dest) {
            this.weight = weight;
            this.visited = visited;
            this.src = src;
            this.dest = dest;
        }
    }


     static class Graph {
        public List<Vertex> v; // vertices
        public List<Edge> e; // edges

        public Graph(List<Vertex> v, List<Edge> e) {
            this.v = v;
            this.e = e;
        }

        // This method returns the vertex with a given id if it
        // already exists in the graph, returns NULL otherwise
        Vertex getVertex(int id) {
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i).id == id) {
                    return v.get(i);
                }
            }
            return null;
        }

        // This method generates the graph with v vertices
        // and e Edges
        void generateGraph(int vertices, List<ArrayList<Integer>> edges) {
            // create vertices
            for (int i = 0; i < vertices; i++) {
                Vertex v = new Vertex(i + 1, false);
                this.v.add(v);
            }

            // create edges
            final int sourcePost = 0;
            final int destPost = 1;
            final int weightPost = 2;
            for (int i = 0; i < edges.size(); i++) {
                Vertex src = getVertex(edges.get(i).get(sourcePost)); // edges[i][0] is source
                Vertex dest = getVertex(edges.get(i).get(destPost)); // edges[i][1] is destination
                Edge e = new Edge(edges.get(i).get(weightPost), false, src, dest); // edges[i][2] is weight
                this.e.add(e); // adding edges
            }
        }

        void printGraph() {
            for (int i = 0; i < this.e.size(); i++) {
                System.out.println("\t" + this.e.get(i).src.id + "--(" + this.e.get(i).weight + ")--"
                                           + this.e.get(i).dest.id);
            }
        }

        String getGraph() {
            String res = "";
            for (int i = 0; i < this.e.size(); i++) {
                if (i == this.e.size() - 1) {
                    res += "[" + this.e.get(i).src.id + "--(" + this.e.get(i).weight + ")--" + this.e.get(i).dest.id + "]";
                } else {
                    res += "[" + this.e.get(i).src.id + "--(" + this.e.get(i).weight + ")--" + this.e.get(i).dest.id + "],";
                }
            }
            return res;
        }

        int getTotalCost() {
            int totalCost = 0;
            for (Edge edge : this.e) {
                totalCost += edge.weight;
            }
            return totalCost;
        }

    }





    public static void main(String[] args) {
        Integer[] v = {5, 7, 2, 3};

        // edges
        // [  1,         2,           1     ]
        // [source, destination, edge_weight]
        Integer[][][] e = {{{1, 2, 1}, {1, 3, 1}, {2, 3, 2}, {2, 4, 3}, {3, 5, 3}, {4, 5, 2}}, // 1st graph
                {{1, 4, 2}, {1, 3, 1}, {1, 2, 2}, {3, 4, 1}, {2, 4, 3}, {3, 5, 2}, {4, 7, 2},
                        {5, 6, 1}, {5, 7, 2}}, // 2nd graph
                {{1, 2, 1}, {2, 1, 1}}, // 3rd graph
                {{1, 2, 3}, {2, 3, 2}}// 4th graph
        };

        for (int i = 0; i < v.length; i++) {
            Graph g = new Graph(new ArrayList<Vertex>(), new ArrayList<Edge>());
            List<ArrayList<Integer>> edgeLst = new ArrayList<ArrayList<Integer>>();
            for (Integer[] arr : e[i]) {
                ArrayList<Integer> lst = new ArrayList<Integer>();
                lst.addAll(Arrays.asList(arr));
                edgeLst.add(lst);
            }
            g.generateGraph(v[i], edgeLst);
            System.out.println((i + 1) + ". Original graph:");
            g.printGraph();
            System.out.println("Total cost of graph: " + g.getTotalCost());

            System.out.println("\nMinimum spanning tree:");
            Graph w = MST.findMinSpanningTree(g);
            w.printGraph();
            System.out.println("Total cost of MST: " + w.getTotalCost());
            System.out.println(
                    "----------------------------------------------------------------------\n");
        }
    }
}




