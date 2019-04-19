package com.nishant.algo;


import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/* We can use Java inbuilt Deque as a double
ended queue to store the cache keys, with
the descending time of reference from front
to back and a set container to check presence
of a key. But remove a key from the Deque using
remove() , it takes O(N) time. This can be
optimized by storing a reference (iterator) to
each key in a hash map. */

class LRUCache {
    // store keys of cache
    private static Deque<Integer> dq;
    // store references of key in cache
    private static HashSet<Integer> map;
    //maximum capacity of cache
    private static int cacheSize;

    LRUCache(int n) {
        dq = new LinkedList<>();
        map = new HashSet<>();
        cacheSize = n;
    }

    /* Refers key x with in the LRU cache */
    public void refer(int x) {
        if (!map.contains(x)) {
            if (dq.size() == cacheSize) {
                int last = dq.removeLast();
                map.remove(last);
            }
        } else {
			/* The found page may not be always the last element, even if it's an
			intermediate element that needs to be removed and added to the start
			of the Queue */
            int index = 0, i = 0;
            for (Integer integer : dq) {
                if (integer == x) {
                    index = i;
                    break;
                }
                i++;
            }
            dq.remove(index);
        }
        dq.push(x);
        map.add(x);
    }

    // display contents of cache
    public void display() {
        for (Integer integer : dq) {
            System.out.print(integer + " ");
        }
    }


}


