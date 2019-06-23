package com.nishant.algo;


import java.util.ArrayList;
import java.util.List;

//Google
public class CanCompleteCircuit {

    //the idea is based in if sum(gas) - sum(cost) >= 0  then there is a solution
    // restart the tank wherever currTank reaches less than 0
    public int canCompleteCircuitLeetCode(int[] gas, int[] cost) {
        int g = gas.length;
        int c = cost.length;

        if (g != c)
            return -1;

        int tank = 0;
        int currTank = 0;
        int start = 0;

        for (int i = 0; i < g; i++) {

            int currDiff = gas[i] - cost[i];
            currTank += currDiff;
            tank += currDiff;

            if (currTank < 0) {
                currTank = 0;
                start = i + 1;
            }
        }
        return tank >= 0 ? start : -1;
    }


    //O(n^2)
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
