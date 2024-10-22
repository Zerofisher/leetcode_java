package com.algorithm.maxuniquesplit;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a method to find the maximum number of unique substrings
 * that a given string can be split into.
 *
 * @author lesion
 */
public class MaxUniqueSplit {
    public static int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private static int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return 0;
        }

        int max = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (!seen.contains(substring)) {
                seen.add(substring);
                int count = 1 + backtrack(s, i, seen);
                max = Math.max(max, count);
                seen.remove(substring);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abac";
        int result = maxUniqueSplit(s);

        System.out.println("Input string: " + s);
        System.out.println("Maximum number of unique substrings: " + result);
    }
}
