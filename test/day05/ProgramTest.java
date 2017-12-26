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
}