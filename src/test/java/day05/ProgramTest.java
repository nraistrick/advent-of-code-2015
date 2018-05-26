package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void isOnNiceList()
    {
        assertTrue(Program.isOnNiceList("ugknbfddgicrmopn"));
        assertTrue(Program.isOnNiceList("aaa"));
        assertFalse(Program.isOnNiceList("jchzalrnumimnmhp"));
        assertFalse(Program.isOnNiceList("haegwjzuvuyypxyu"));
        assertFalse(Program.isOnNiceList("dvszwmarrgswjxmb"));
    }

    @Test
    void isOnImprovedNiceList()
    {
        assertTrue(Program.isOnImprovedNiceList("qjhvhtzxzqqjkmpb"));
        assertTrue(Program.isOnImprovedNiceList("xxyxx"));
        assertFalse(Program.isOnImprovedNiceList("uurcxstgmygtbstg"));
        assertFalse(Program.isOnImprovedNiceList("ieodomkazucvgmuy"));
    }

    @Test
    void containsThreeVowels()
    {
        assertTrue(Program.containsThreeVowels("aeiouaeiouaeiou"));
        assertFalse(Program.containsThreeVowels("dvszwmarrgswjxmb"));
    }

    @Test
    void containsRepeatedLetter()
    {
        assertTrue(Program.containsRepeatedLetter("aabbccdd"));
        assertFalse(Program.containsRepeatedLetter("jchzalrnumimnmhp"));
    }

    @Test
    void containsInvalidString()
    {
        assertTrue(Program.containsInvalidString("haegwjzuvuyypxyu"));
        assertFalse(Program.containsInvalidString("aeiouaeiouaeiou"));
    }

    @Test
    void containsNonOverlappingRepeatedLetters()
    {
        assertTrue(Program.containsNonOverlappingRepeatedLetters("xyxy"));
        assertTrue(Program.containsNonOverlappingRepeatedLetters("aabcdefgaa"));
        assertFalse(Program.containsNonOverlappingRepeatedLetters("aaa"));
    }

    @Test
    void containsRepeatingSequence()
    {
        assertTrue(Program.containsRepeatingSequence("aaa"));
        assertTrue(Program.containsRepeatingSequence("xyx"));
        assertTrue(Program.containsRepeatingSequence("abcdefeghi"));
    }
}