package com.nishant.algo;


/*
doesn't work for empty string ""
 */

import java.util.ArrayList;
import java.util.List;

class Search {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        TrieNode root = constructTrie(words);
        for (int i = 0; i < words.length; i++) {
            searchPair(words[i], i, pairs, root);
        }

        return pairs;


    }

    public void searchPair(String word, int i, List<List<Integer>> pairs, TrieNode ptr) {
        for (int j = 0; j < word.length(); j++) {
            char currLetter = word.charAt(j);
            TrieNode child = ptr.next[currLetter - 'a'];
            if (child == null)
                return;

            ptr = child;
        }
        if (ptr.isPalindromeAhead) {
            if (i != ptr.index) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(ptr.index);
                pairs.add(pair);
            }
        }
    }

    public TrieNode constructTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            char[] letters = words[i].toCharArray();
            TrieNode curr = root;
            for (int j = letters.length - 1; j >= 0; j--) {
                int index = letters[j] - 'a';
                if (curr.next[index] == null)
                    curr.next[index] = new TrieNode();
                curr = curr.next[index];
                if (isPalindromeAhead(words[i], j)) {
                    curr.isPalindromeAhead = true;
                    if (curr.index == 0)
                        curr.index = i;
                }
            }
        }
        return root;
    }

    private boolean isPalindromeAhead(String word, int j) {
        j -= 1;
        int i = 0;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int index;
        boolean isPalindromeAhead;
    }
}

