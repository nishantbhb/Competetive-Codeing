package visa;

import java.util.List;

public class Product {
    public static long countSubarrays(List<Integer> numbers, int k) {
        // Write your code here

        if (numbers == null || numbers.size() == 0)
            return 0;

        int ctr = 0;
        int prod = 1;

        int j = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int rightWindow = numbers.get(i);
            prod *= rightWindow;
            while (j < i && prod > k) {
                prod /= numbers.get(j++);
            }
            if (prod <= k) {
                ctr += 1 + (i - j);
            }
        }
        return ctr;
    }
}
