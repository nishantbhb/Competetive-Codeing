/*
A "valid" string is a string  such that for all distinct characters in  each such character occurs the same number of times in .

For example, aabb is a valid string because the frequency of both characters a and b is , whereas aabbc is not a valid string because the frequency of characters a, b, and c is not the same.

Watson gives a string  to Sherlock and asks him to remove some characters from the string such that the new string is a "valid" string.

Sherlock wants to know from you if it's possible to be done with less than or equal to one removal.

Input Format

The first and only line contains , the string Watson gives to Sherlock.

Constraints

String  contains lowercase letters only ().
Output Format

Output YES if string  can be converted to a "valid" string by removing less than or equal to one character. 
Else, output NO.

Sample Input

aabbcd
Sample Output

NO
Explanation

 is the minimum number of removals required to make it a valid string. It can be done in following two ways:

Remove c and d to get aabb. 
Or remove a and b to get abcd.
*/


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input[] = in.nextLine().split("");

        //to store the count of each letter
        Map<String, Integer> ltr = new HashMap<String, Integer>();
        for (int i = 0; i < input.length; i++) {
            if (ltr.containsKey(input[i])) {
                int val = ltr.get(input[i]);
                val++;
                ltr.put(input[i], val);
            } else {
                ltr.put(input[i], 1);
            }
        }

        //to store the distinct letter-counts
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        for (Entry<String, Integer> m : ltr.entrySet()) {
            int k = m.getValue();
            if (cnt.containsKey(k)) {
                int val = cnt.get(k);
                val++;
                cnt.put(k, val);
            } else {
                cnt.put(k, 1);
            }
        }
        //to check if valid string
        int flag = 0;

        //only one letter for whole string or equal frequency of each letter
        if (cnt.size() == 1) {
            flag = 1;
        } else if (cnt.size() == 2) { //if only two distinct frequency of letters
            int a[] = new int[2];
            int b[] = new int[2];
            int i = 0;
            for (Entry<Integer, Integer> m : cnt.entrySet()) {
                a[i] = m.getKey(); //letter frequency
                b[i] = m.getValue(); //Occurrence of frequency
                i++;
            }
            //if only one distinct frequency
            if (b[1] == 1 || b[0] == 1) {
                if (a[0] == 1 || a[1] == 1) {//if a distinct frequency letter occurs only once
                    flag = 1;
                } else if (((a[0] - a[1]) == 1) || ((a[1] - a[0]) == 1))//if frequency difference is just 1
                    if ((a[0] < a[1] && b[0] > b[1]) || (a[0] > a[1] && b[0] < b[1])) {//to check if letter to be deleted occurs only once
                        flag = 1;
                    }

            }
        }
        if (flag == 1)
            System.out.println("YES");

        else
            System.out.println("NO");
        in.close();
    }

}
