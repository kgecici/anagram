package org.kg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Some of the test cases taken from: https://en.wikipedia.org/wiki/Anagram
class AnagramCheckerTest {

    @Test
    public void testEmptyOrNullString() {
        assertFalse(AnagramChecker.isAnagram(null, null));
        assertFalse(AnagramChecker.isAnagram(null, "a"));
        assertFalse(AnagramChecker.isAnagram("a", null));
        assertFalse(AnagramChecker.isAnagram("", "a"));
    }

    @Test
    public void testDiffentLen() {
        assertFalse(AnagramChecker.isAnagram("x", "a"));
    }

    @Test
    public void testAnagramSimple() {
        assertTrue(AnagramChecker.isAnagram("abc", "cba"));
        assertTrue(AnagramChecker.isAnagram("coronavirus", "carnivorous"));
    }

    @Test
    public void testAnagramSimpleWithDigit() {
        // We are not expecting and digit
        assertThrows(IllegalArgumentException.class, () -> AnagramChecker.isAnagram("abc1", "1cba"));
    }

    @Test
    public void testAnagramWhitespace() {
        assertTrue(AnagramChecker.isAnagram("abc", "cba"));
        assertTrue(AnagramChecker.isAnagram("coronavirus", "carnivorous"));
    }

    @Test
    public void testAnagramMultiWordAndDiffernetCase() {
        assertTrue(AnagramChecker.isAnagram("New York Times", "monkeys write"));
    }

    @Test
    public void testAnagramHypenOrSimilar() {
        assertTrue(AnagramChecker.isAnagram("Church of Scientology", "rich-chosen goofy cult"));
        assertTrue(AnagramChecker.isAnagram("McDonald's restaurants", "Uncle Sam's standard rot"));
        assertTrue(AnagramChecker.isAnagram("McDonald's restaurants", "Uncle Sams standard rot"));
        assertTrue(AnagramChecker.isAnagram("She Sells Sanctuary", "Satan; cruel, less shy"));
        assertTrue(AnagramChecker.isAnagram("She Sells Sanctuary", "Santa; shy, less cruel"));
        assertTrue(AnagramChecker.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));

    }
}