package visa;

import java.util.ArrayList;
import java.util.List;

public class Prefix {
    public static List<Integer> findCompletePrefixes(List<String> names, List<String> query) {
        // Write your code here
        List<Integer> counts = new ArrayList<>();
        if (query == null || query.size() == 0) {
            return counts;
        }


        for (String prefix : query) {
            int ctr = 0;
            for (String name : names) {
                int q = 0;
                int n = 0;

                while (q < prefix.length() && n < name.length()
                        && prefix.charAt(q) == name.charAt(n)) {
                    q++;
                    n++;
                }
                if (q == prefix.length() && n < name.length())
                    ctr++;
            }
            counts.add(ctr);

        }
        return counts;

    }
}
