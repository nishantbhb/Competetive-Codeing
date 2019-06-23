package com.nishant.algo;


import java.util.ArrayList;
import java.util.List;

//Google
public class CanCompleteCircuit {


    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {

        if (gas.size() != cost.size())
            return -1;

        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < gas.size(); i++) {
            diff.add(i, gas.get(i) - cost.get(i));
        }

        for (int i = 0; i < gas.size(); i++) {
            int sum = 0;
            int j = i;
            int ctr = 0;
            while (ctr < gas.size()) {
                sum += diff.get(j);

                if (sum < 0)
                    break;

                j = (j + 1) % gas.size();

                ctr++;

            }
            if (ctr == gas.size())
                return i;
        }
        return -1;
    }


}
