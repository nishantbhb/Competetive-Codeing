package com.nishant.algo;


import java.util.HashMap;
import java.util.Map;


class WordDictionary {

    public boolean searchWord(TrieNode root, String word, int i) {
        char currLetter = word.charAt(i);
        String remWord = word.substring(i);
        Map<Character, TrieNode> children = root.children;
        if (remWord.length() == 1) {
            if (currLetter != '.') {
                TrieNode child = children.get(currLetter);
                return child != null && child.eow;
            } else {
                return children.entrySet().stream().anyMatch(childNodes -> childNodes.getValue().eow);
            }
        }

        if (currLetter == '.') {
            for (Map.Entry<Character, TrieNode> trieNode : root.children.entrySet()) {
                if (searchWord(trieNode.getValue(), word, i + 1))
                    return true;
            }
        }
        TrieNode child = children.get(currLetter);
        if (child == null)
            return false;
        return searchWord(child, word, i + 1);


    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode();

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchWord(root, word, 0);
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
    /*
    public boolean searchWord(TrieNode root, String word, int i) {
        if (root == null)
            return false;
        if (word.length() == i)
            return root.eow;
        char currLetter = word.charAt(i);
        Map<Character, TrieNode> children = root.children;

        if (currLetter == '.') {
            for (Map.Entry<Character, TrieNode> trieNode : root.children.entrySet()) {
                if (searchWord(trieNode.getValue(), word, i + 1))
                    return true;
            }
        }
        TrieNode child = children.get(currLetter);
        if (child == null)
            return false;
        return searchWord(child, word, i + 1);
    }
     */


}

class SearchWordTrie {


    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}


