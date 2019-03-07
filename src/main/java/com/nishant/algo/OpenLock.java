package com.nishant.algo;


import java.util.*;

public class OpenLock {
    static int openLock(String[] deadends, String target) {
        Set<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        Queue<String> combinations = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        if (target.equals("0000"))
            return 0;
        if (deadEnds.contains(target) || deadEnds.contains("0000"))
            return -1;
        combinations.offer("0000");
        int turns = 0;
        while (!combinations.isEmpty()) {
            int qSize = combinations.size();

            while (qSize != 0) {
                String currCombination = combinations.poll();

                if (currCombination.equals(target))
                    return turns;

                if (visited.contains(currCombination)) {
                    qSize--;
                    continue;
                }

                visited.add(currCombination);
                StringBuilder sb = new StringBuilder(currCombination);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);

                    if (!deadEnds.contains(s1) && !visited.contains(s1))
                        combinations.offer(s1);

                    if (!deadEnds.contains(s2) && !visited.contains(s2))
                        combinations.offer(s2);
                }

                qSize--;
            }
            turns++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"8888"}, "0009"));
    }

}