package com.nishant.algo;


import java.util.HashMap;
import java.util.Map;


class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] characters = word.toCharArray();
        TrieNode ptr = root;

        for (char letter : characters) {
            Map<Character, TrieNode> children = ptr.children;
            TrieNode child = children.get(letter);
            if (child != null) {
                ptr = child;
            } else {
                TrieNode newChild = new TrieNode(letter);
                children.put(letter, newChild);
                ptr = newChild;
            }
        }
        ptr.eow = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] characters = word.toCharArray();
        TrieNode ptr = root;

        for (char letter : characters) {
            Map<Character, TrieNode> children = ptr.children;
            TrieNode child = children.get(letter);
            if (child == null) {
                return false;
            }
            ptr = child;
        }
        return ptr.eow;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] characters = prefix.toCharArray();
        TrieNode ptr = root;

        for (char letter : characters) {
            Map<Character, TrieNode> children = ptr.children;
            TrieNode child = children.get(letter);
            if (child == null) {
                return false;
            }
            ptr = child;
        }
        return true;
    }

    class TrieNode {
        char val;
        boolean eow;//end of word
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();

        }

        TrieNode(char val) {
            this.val = val;
            children = new HashMap<>();
        }
    }
}

