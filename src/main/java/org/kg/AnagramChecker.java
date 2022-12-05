package org.kg;

import java.util.List;
import java.util.stream.Collectors;

public class AnagramChecker {

    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        List<Character> sortedChars1 = toSortedCharList(s1);
        List<Character> sortedChars2 = toSortedCharList(s2);

        return sortedChars1.equals(sortedChars2);
    }

    private static List<Character> toSortedCharList(String s) {
        return s.trim().chars()
            .mapToObj(e -> Character.toLowerCase((char) e))
            .filter(c-> {
                if (Character.isDigit(c))
                    throw new IllegalArgumentException("String cannot contain digit");
                return Character.isAlphabetic(c);
            })
            .sorted().collect(Collectors.toList());
    }
}
