package com.ricardohui.javaCodingInterview.trie;
/* Not done by Ricardo. Ricardo used HashMap approach
* https://www.hackerrank.com/challenges/contacts/problem
*
* Sample input to this program
* 4\n
* add hack\n
* add hackerrank\n
* find hac\n
* find hak\n
* */
import java.util.Scanner;

class TrieNode {
    char c;
    TrieNode[] children = new TrieNode[26];
    boolean isLeafNode;
    int count;

    TrieNode(char c, boolean isLeafNode, int count) {
        this.c = c;
        this.isLeafNode = isLeafNode;
        this.count = count;
    }
}

public class Contact {

    static TrieNode root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        root = new TrieNode(' ', false, 0);
        for (int tc = 1; tc <= T; tc++) {
            String operation = sc.next();
            String input = sc.next();
            if (operation.equals("add")) {
                insert(input);
            } else {
                System.out.println(find(input));
            }

        }
    }

    public static void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children[ch - 'a'];
            if (node == null) {
                current.children[ch - 'a'] = new TrieNode(ch, false, 1);
            } else {
                current.children[ch - 'a'].count = current.children[ch - 'a'].count + 1;
            }
            current = current.children[ch - 'a'];
        }
        current.isLeafNode = true;
    }

    public static int find(String prefix) {
        TrieNode curr = root;
        int c = 0;
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            if (!containsKey(curr, ch)) {
                return 0;
            } else {
                curr = curr.children[ch - 'a'];
            }

        }
        return curr.count;
    }

    private static boolean containsKey(TrieNode curr, char ch) {
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null)
                if (curr.children[i].c == ch) {
                    return true;
                }
        }
        return false;
    }

    private static int getChidrenSize(TrieNode curr) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                count++;
            }
        }
        return count;
    }

}