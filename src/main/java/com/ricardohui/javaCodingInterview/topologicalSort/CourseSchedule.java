package com.ricardohui.javaCodingInterview.topologicalSort;

import java.util.*;

class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

      // initialize graph and inDegree 
      Map<Integer, List<Integer>> graph = new HashMap<>();
      Map<Integer, Integer> inDegreeMap = new HashMap<>();
      for (int i = 0; i < numCourses; i++) {
        graph.put(i, new ArrayList<>());
        inDegreeMap.put(i, 0);
      }

      // build the graph and inDegree
      for (int[] prereq : prerequisites) {
       int source = prereq[0];
       int destination = prereq[1];
        graph.get(source).add(destination);
        inDegreeMap.put( destination, inDegreeMap.get(destination)+1);
      }

      // start with any course with no dependency
      Queue<Integer> queue = new LinkedList<>();
      List<Integer> sorted = new ArrayList<>();
      for (Map.Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
          if (entry.getValue() == 0) {
            queue.add(entry.getKey());
          }
      } 

      // while the queue is not empty, keep looping
      while (!queue.isEmpty()) {
       int source = queue.poll(); 
       sorted.add(source);
      
       List<Integer> prereqs = graph.get(source);
      for (Integer integer : prereqs) {
       inDegreeMap.put(integer, inDegreeMap.get(integer)-1);    
        if (inDegreeMap.get(integer)==0) {
          queue.add(integer);
        }

      }
      }
        return sorted.size() == numCourses;
    }
    public static void main(String[] args) {
      
      // Test case 1: No cycle
      int numCourses1 = 2;
      int[][] prerequisites1 = {{1,0}};
      boolean result1 = CourseSchedule.canFinish(numCourses1, prerequisites1);
      System.out.println("Test case 1 (Expected: true): " + result1);
      
      // Test case 2: Cycle present
      int numCourses2 = 2;
      int[][] prerequisites2 = {{1,0}, {0,1}};
      boolean result2 = CourseSchedule.canFinish(numCourses2, prerequisites2);
      System.out.println("Test case 2 (Expected: false): " + result2);
      
      // Test case 3: Multiple courses, no cycle
      int numCourses3 = 4;
      int[][] prerequisites3 = {{1,0}, {2,1}, {3,2}};
      boolean result3 = CourseSchedule.canFinish(numCourses3, prerequisites3);
      System.out.println("Test case 3 (Expected: true): " + result3);
      
      // Test case 4: Multiple courses, cycle present
      int numCourses4 = 4;
      int[][] prerequisites4 = {{1,0}, {2,1}, {3,2}, {0,3}};
      boolean result4 = CourseSchedule.canFinish(numCourses4, prerequisites4);
      System.out.println("Test case  4 (Expected: false): " + result4);
      
      // Test case 5: No prerequisites
      int numCourses5 = 3;
      int[][] prerequisites5 = {};
      boolean result5 = CourseSchedule.canFinish(numCourses5, prerequisites5);
      System.out.println("Test case 5 (Expected: true): " + result5);
    }
}