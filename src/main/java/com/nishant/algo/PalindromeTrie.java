package com.nishant.algo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PalindromeTrie {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], i, root);
        }
        for (int i = 0; i < words.length; i++) {
            search(i, words, root, result);
        }
        return result;
    }

    private void addWord(String word, int index, TrieNode root) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int nextIndex = word.charAt(i) - 'a';
            if (root.next[nextIndex] == null) {
                root.next[nextIndex] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }
            root = root.next[nextIndex];
        }
        root.index = index;
        root.list.add(index);
    }

    private void search(int index, String[] words, TrieNode root, List<List<Integer>> result) {
        for (int i = 0; i < words[index].length(); i++) {
            int nextIndex = words[index].charAt(i) - 'a';
            if (root.index != -1 && root.index != index && isPalindrome(words[index], i, words[index].length() - 1)) {
                result.add(Arrays.asList(index, root.index));
            }
            root = root.next[nextIndex];
            if (root == null) {
                return;
            }
        }
        for (int i : root.list) {
            if (i == index) continue;
            result.add(Arrays.asList(index, i));
        }

    }

    private boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    class TrieNode {
        TrieNode[] next;
        int index; //index of the word
        List<Integer> list; //Store the index of word which its remaining is palindrome

        public TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
}