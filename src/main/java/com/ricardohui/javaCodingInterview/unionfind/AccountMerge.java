package com.ricardohui.javaCodingInterview.unionfind;

import java.util.*;

class AccountMerge {
    // Class to implement union-find data structure
    class UnionFind {
        private Map<String, String> parent;
        private Map<String, Integer> rank;
        
        public UnionFind() {
            parent = new HashMap<>();
            rank = new HashMap<>();
        }
        
        public void add(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 0);
            }
        }
        
        public String find(String x) {
            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }
        
        public void union(String x, String y) {
            String px = find(x);
            String py = find(y);
            
            if (!px.equals(py)) {
                if (rank.get(px) < rank.get(py)) {
                    parent.put(px, py);
                } else if (rank.get(px) > rank.get(py)) {
                    parent.put(py, px);
                } else {
                    parent.put(py, px);
                    rank.put(px, rank.get(px) + 1);
                }
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();
        
        // Step 1: Build the union-find data structure
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                uf.add(email);
                emailToName.put(email, name);
                if (i > 1) {
                    uf.union(account.get(1), email);
                }
            }
        }
        
        // Step 2: Group emails by their representative
        Map<String, Set<String>> merged = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String rep = uf.find(email);
            merged.computeIfAbsent(rep, k -> new TreeSet<>()).add(email);
        }
        
        // Step 3: Format the result
        List<List<String>> result = new ArrayList<>();
        for (Set<String> emails : merged.values()) {
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(emails.iterator().next())); // Add name
            account.addAll(emails); // Add sorted emails
            result.add(account);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
      AccountMerge solution = new AccountMerge();
        
        // Test Case 1: Basic merge
        List<List<String>> accounts1 = Arrays.asList(
            Arrays.asList("John", "john@example.com", "john_doe@example.com"),
            Arrays.asList("John", "john@example.com", "john@another.com")
        );
        List<List<String>> result1 = solution.accountsMerge(accounts1);
        System.out.println("Test Case 1 - Expected: [[John, john@another.com, john@example.com, john_doe@example.com]]");
        System.out.println("Actual: " + result1);
        
        // Test Case 2: No merge needed
        List<List<String>> accounts2 = Arrays.asList(
            Arrays.asList("Mary", "mary@mail.com"),
            Arrays.asList("John", "john@mail.com")
        );
        List<List<String>> result2 = solution.accountsMerge(accounts2);
        System.out.println("\nTest Case 2 - Expected: [[John, john@mail.com], [Mary, mary@mail.com]]");
        System.out.println("Actual: " + result2);
        
        // Test Case 3: Complex merge with multiple accounts
        List<List<String>> accounts3 = Arrays.asList(
            Arrays.asList("John", "john@example.com", "john_doe@example.com"),
            Arrays.asList("Mary", "mary@mail.com"),
            Arrays.asList("John", "john_doe@example.com", "john@another.com"),
            Arrays.asList("Mary", "mary@mail.com", "mary@backup.com")
        );
        List<List<String>> result3 = solution.accountsMerge(accounts3);
        System.out.println("\nTest Case 3 - Expected merged accounts for John and Mary");
        System.out.println("Actual: " + result3);
    }
}