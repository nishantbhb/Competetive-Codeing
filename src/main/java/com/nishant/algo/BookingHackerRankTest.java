package com.nishant.algo;

import java.util.*;

public class BookingHackerRankTest {

    public static List<Integer> delta_encode(List<Integer> numbers) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        if (numbers == null || numbers.size() == 0)
            return list;
        int esc_token = -128;

        list.add(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            long diff = (long) numbers.get(i) - (long) numbers.get(i - 1);
            if (Math.abs(diff) > 128)
                list.add(esc_token);
            list.add((int) diff);
        }

        return list;

    }

    static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
        int size = callsTimes.size();
        long[] start = new long[size];
        long[] end = new long[size];
        for (int i = 0; i < callsTimes.size(); i++) {
            List<Integer> callDuration = callsTimes.get(i);
            start[i] = callDuration.get(0);
            end[i] = callDuration.get(1);

        }

        int execReq = 1, max = 1;
        int i = 1, j = 0;

        while (i < size && j < size) {

            if (start[i] <= end[j]) {
                execReq++;
                i++;

                if (execReq > max)
                    max = execReq;
            } else {
                execReq--;
                j++;
            }
        }
        return execReq - noOfCurrentAgents;

    }

    static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
        String[] keysArray = keywords.split(" ");
        Set<String> keys = new HashSet<>(Arrays.asList(keysArray));

        Map<Integer, Integer> matches = new HashMap<>();
        int i = 0;
        for (; i < reviews.size(); i++) {
            String[] review = reviews.get(i).split(" ");
            for (String word : review) {
                if (keys.contains(word)) {
                    int hotel = hotel_ids.get(i);
                    matches.put(hotel, matches.getOrDefault(hotel, 0) + 1);
                }

            }

        }
        while (i < hotel_ids.size()) {
            matches.put(hotel_ids.get(i), 0);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(matches.entrySet());


        //reverse order
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        //list.sort(Comparator.comparing(Map.Entry::getValue));

        Map<Integer, Integer> sortedList = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            sortedList.put(aa.getKey(), aa.getValue());
        }

        return new ArrayList<>(sortedList.keySet());


    }

}


