package com.nishant.algo;


import java.util.List;

/*
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
 */

class ReplaceWordByRoot {


    public static void main(String[] args) {

    }

    String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (String root : dict) {
                if (words[i].startsWith(root)) {
                    words[i] = root;
                    break;
                }
            }
        }
        return String.join(" ", words);


    }
}