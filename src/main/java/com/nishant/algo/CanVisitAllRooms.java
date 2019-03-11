package com.nishant.algo;

import java.util.*;

public class CanVisitAllRooms {


    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0)
            return true;
        Set<Integer> visitedRooms = new HashSet<>();
        Queue<Integer> keysQueue = new LinkedList<>();
        for (Integer key : rooms.get(0))
            keysQueue.offer(key);

        visitedRooms.add(0);//add the initial visited room 0

        while (!keysQueue.isEmpty()) {
            int size = keysQueue.size();

            while (size > 0) {
                Integer key = keysQueue.poll();
                if (!visitedRooms.contains(key)) {

                    List<Integer> currRoomKeys = rooms.get(key);
                    if (currRoomKeys == null || currRoomKeys.size() == 0) {
                        visitedRooms.add(key);
                        size--;
                        continue;
                    }

                    for (Integer keyInRoom : currRoomKeys) {
                        keysQueue.offer(keyInRoom);
                        visitedRooms.add(key);
                    }
                }
                size--;
            }
        }
        return visitedRooms.size() == rooms.size();

    }

    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(canVisitAllRooms([[1,3],[3,0,1],[2],[0])));
    }

}