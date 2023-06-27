package com.ricardohui.javaCodingInterview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordChaining {

    public static void main(String[] args) {
        String[][] inputsArr = {{"eve", "eat", "ripe", "tear"}, {"hit", "hot", "dot", "dog", "cog"},
                {"aa", "ba", "ab"}, {"apple", "juice"}};
        List<List<String>> inputs = new ArrayList<List<String>>();
        for (String[] arr : inputsArr) {
            inputs.add(Arrays.asList(arr));
        }

        for (int i = 0; i < inputsArr.length; i++) {
            List<VertexChain> vertices = new ArrayList<VertexChain>();
            GraphChain g = new GraphChain(vertices);
            g.createGraph(inputs.get(i));
            Boolean result = g.canChainWords(inputs.get(i).size());
            System.out.println((i + 1) + "\tList of words: " + "['"
                                       + String.join("', '", inputs.get(i)) + "']");
            System.out.println("\tIs word chaining possible?: " + result);
            System.out.println(
                    "----------------------------------------------------------------------------------------");
        }
    }
    public static class GraphChain {
        private List<VertexChain> g;

        public GraphChain(List<VertexChain> g) {
            super();
            this.g = g;
        }

        // This method returns TRUE if the graph has a cycle containing
        // all the nodes, returns FALSE otherwise
        boolean canChainWordsRec(VertexChain node, VertexChain startingNode) {
            node.visited = true;

            // Base case
            // return TRUE if all nodes have been visited and there
            // exists an edge from the last node being visited to
            // the starting node
            List<VertexChain> adj = node.adjVertices;
            if (this.allVisited()) {
                for (int i = 0; i < adj.size(); i++) {
                    if (adj.get(i) == startingNode) {
                        return true;
                    }
                }
            }

            // Recursive case
            for (int i = 0; i < adj.size(); i++) {
                if (adj.get(i).visited == false) {
                    node = adj.get(i);
                    if (canChainWordsRec(node, startingNode)) {
                        return true;
                    }
                }
            }

            return false;
        }


        // Challenge function
        boolean canChainWords(int listSize) {
            // Empty list and single word cannot form a chain

            if (listSize <= 1) {
                return false;
            }

            if (!this.g.isEmpty() && this.outEqualsIn()) {
                return this.canChainWordsRec(this.g.get(0), this.g.get(0));
            }

            return false;
        }

        // This method creates a graph from a list of words. A node of
        // the graph contains a character representing the start or end
        // character of a word.
        void createGraph(List<String> wordsList) {
            for (int i = 0; i < wordsList.size(); i++) {
                String word = wordsList.get(i);
                char startChar = word.charAt(0);
                char endChar = word.charAt(word.length() - 1);

                VertexChain start = VertexChainExists(startChar);

                if (start == null) {
                    start = new VertexChain(startChar, false);
                    this.g.add(start);
                }

                VertexChain end = VertexChainExists(endChar);

                if (end == null) {
                    end = new VertexChain(endChar, false);
                    this.g.add(end);
                }

                // Add an edge from start vertex to end vertex
                addEdge(start, end);
            }
        }

        // This method returns the vertex with a given value if it
        // already exists in the graph, returns NULL otherwise
        VertexChain VertexChainExists(char value) {
            for (int i = 0; i < this.g.size(); i++) {
                if (this.g.get(i).value == value) {
                    return this.g.get(i);
                }
            }
            return null;
        }

        // This method returns TRUE if all nodes of the graph have
        // been visited
        boolean allVisited() {
            for (int i = 0; i < this.g.size(); i++) {
                if (this.g.get(i).visited == false) {
                    return false;
                }
            }
            return true;
        }

        // This method adds an edge from start vertex to end vertex by
        // adding the end vertex in the adjacency list of start vertex
        // It also adds the start vertex to the inVertices of end vertex
        void addEdge(VertexChain start, VertexChain end) {
            start.adjVertices.add(end);
            end.inVertices.add(start);
        }

        // This method returns TRUE if out degree of each vertex is equal
        // to its in degree, returns FALSE otherwise
        Boolean outEqualsIn() {
            for (int i = 0; i < this.g.size(); i++) {
                int out = this.g.get(i).adjVertices.size();
                int inn = this.g.get(i).inVertices.size();
                if (out != inn) {
                    return false;
                }
            }
            return true;
        }

        void printGraph() {
            for (int i = 0; i < this.g.size(); i++) {
                System.out.println(this.g.get(i).value + " " + this.g.get(i).visited);
                System.out.println(this.g.get(i).value + " " + this.g.get(i).visited);
                List<VertexChain> adj = this.g.get(i).adjVertices;
                for (int j = 0; j < adj.size(); j++) {
                    System.out.println(adj.get(j).value + " ");
                }
            }
        }
    }
    public static class VertexChain {
        public char value;
        public boolean visited;
        public List<VertexChain> adjVertices;
        public List<VertexChain> inVertices;

        public VertexChain(char value, boolean visited) {
            this.value = value;
            this.visited = visited;
            this.adjVertices = new ArrayList<VertexChain>();
            this.inVertices = new ArrayList<VertexChain>();
        }
    }
}
