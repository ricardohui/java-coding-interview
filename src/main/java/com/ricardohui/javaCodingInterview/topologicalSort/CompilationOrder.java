package com.ricardohui.javaCodingInterview.topologicalSort;

import java.util.*;

class CompilationOrder {
    public String[] findCompilationOrder(String[][] dependencies) {
      int len = dependencies.length;
      HashMap<String, List<String>> graph = new HashMap<>();
      HashMap<String, Integer> inDegreeMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
          // question I have: find out all the distinct characters and initialize the graph
          String parent = dependencies[i][0];
          String child = dependencies[i][1];
          graph.put(parent, new ArrayList<>());
          graph.put(child, new ArrayList<>());
          inDegreeMap.put(parent, 0);
          inDegreeMap.put(child, 0);
        }
      // build graph and indegree
        for (String[] depenency : dependencies) {
         String parent = depenency[0];
         String child = depenency[1];
         
         graph.get(parent).add(child);
          inDegreeMap.put(child, inDegreeMap.get(child)+1);

          }


      ArrayList<String> sortedOrder = new ArrayList<String>();
      Queue<String> queue = new LinkedList<>();
      // find the one with 0 indegree called source
        for (Map.Entry<String, Integer>  entry: inDegreeMap.entrySet()) {
          if (entry.getValue()==0) {
            queue.add(entry.getKey());
          } 
        }
      // loop the queue and peel off the source node
          while (!queue.isEmpty()) {
            String source = queue.poll();
           sortedOrder.add(source);
            Iterator<String> iterator = graph.get(source).iterator();
            while (iterator.hasNext()) {
              String dep = iterator.next();
              inDegreeMap.put(dep, inDegreeMap.get(dep)-1);
              if (inDegreeMap.get(dep)==0) {
                queue.add(dep);
              }
            }
            
          }
      
      
      // return the sortedOrder
      // question I have: how to convert ArrayList to String[] using Java Stream syntax
      
      return sortedOrder.toArray(new String[0]);
    }
    
    public static void main(String[] args) {
        CompilationOrder solution = new CompilationOrder();
        
        // Test case 1: Simple dependency chain
        String[][] dependencies1 = {{"B", "A"}, {"C", "B"}};
        String[] result1 = solution.findCompilationOrder(dependencies1);
        System.out.println("Test case 1 (Expected: A, B, C): " + Arrays.toString(result1));
        
        // Test case 2: Multiple independent chains
        String[][] dependencies2 = {{"B", "A"}, {"C", "B"}, {"E", "D"}, {"F", "E"}};
        String[] result2 = solution.findCompilationOrder(dependencies2);
        System.out.println("Test case 2 (Expected: A, D, B, E, C, F or D, A, E, B, F, C): " + Arrays.toString(result2));
        
        // Test case 3: Cyclic dependency
        String[][] dependencies3 = {{"B", "A"}, {"C", "B"}, {"A", "C"}};
        String[] result3 = solution.findCompilationOrder(dependencies3);
        System.out.println("Test case 3 (Expected: [] - cyclic dependency): " + Arrays.toString(result3));
        
        // Test case 4: Complex dependency graph
        String[][] dependencies4 = {{"B", "A"}, {"C", "A"}, {"D", "B"}, {"D", "C"}, {"E", "D"}, {"F", "D"}};
        String[] result4 = solution.findCompilationOrder(dependencies4);
        System.out.println("Test case 4 (Expected: A, B, C, D, E, F or A, B, C, D, F, E): " + Arrays.toString(result4));
        
        // Test case 5: No dependencies
        String[][] dependencies5 = {{"A", "B"}, {"C", "D"}, {"E", "F"}};
        String[] result5 = solution.findCompilationOrder(dependencies5);
        System.out.println("Test case 5 (Expected: B, D, F, A, C, E in any order): " + Arrays.toString(result5));
    }
}