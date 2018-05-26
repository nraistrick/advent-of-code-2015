package day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void calculateNewPassword()
    {
        assertEquals("abcdffaa", Program.calculateNewPassword("abcdefgh"));
        assertEquals("ghjaabcc", Program.calculateNewPassword("ghijklmn"));
    }

    @Test
    void passwordMeetsRequirements()
    {
        assertTrue(Program.passwordMeetsRequirements("ghjaabcc"));
        assertTrue(Program.passwordMeetsRequirements("abcdffaa"));

        assertFalse(Program.passwordMeetsRequirements("hijklmmn"));
        assertFalse(Program.passwordMeetsRequirements("abbceffg"));
        assertFalse(Program.passwordMeetsRequirements("abbcegjk"));
    }

    @Test
    void incrementPassword()
    {
        assertEquals("xy", Program.incrementPassword("xx"));
        assertEquals("xz", Program.incrementPassword("xy"));
        assertEquals("ya", Program.incrementPassword("xz"));
        assertEquals("yb", Program.incrementPassword("ya"));

        assertEquals("aabaaa", Program.incrementPassword("aaazzz"));
    }

    @Test
    void passwordContainsStraight()
    {
        assertTrue(Program.passwordContainsStraight("abc"));
        assertTrue(Program.passwordContainsStraight("pojabc"));
        assertTrue(Program.passwordContainsStraight("abcpoj"));
        assertTrue(Program.passwordContainsStraight("xxyzxx"));
        assertTrue(Program.passwordContainsStraight("dddefd"));

        assertFalse(Program.passwordContainsStraight("ghdwiq"));
        assertFalse(Program.passwordContainsStraight("aaaaaa"));
        assertFalse(Program.passwordContainsStraight("poiuyt"));
    }

    @Test
    void passwordContainsInvalidCharacters()
    {
        assertTrue(Program.passwordContainsInvalidCharacters("l"));
        assertTrue(Program.passwordContainsInvalidCharacters("i"));
        assertTrue(Program.passwordContainsInvalidCharacters("abcdo"));
        assertTrue(Program.passwordContainsInvalidCharacters("labcd"));
        assertTrue(Program.passwordContainsInvalidCharacters("aboocd"));

        assertFalse(Program.passwordContainsInvalidCharacters("acbdefg"));
        assertFalse(Program.passwordContainsInvalidCharacters("hmjkmnp"));
        assertFalse(Program.passwordContainsInvalidCharacters("xyzxyzx"));
    }

    @Test
    void passwordContainsTwoRepeatedPairs()
    {
        assertTrue(Program.passwordContainsTwoRepeatedPairs("aabb"));
        assertTrue(Program.passwordContainsTwoRepeatedPairs("yyxx"));
        assertTrue(Program.passwordContainsTwoRepeatedPairs("abcyyaxx"));
        assertTrue(Program.passwordContainsTwoRepeatedPairs("abcyyyaxx"));

        assertFalse(Program.passwordContainsTwoRepeatedPairs("yyyy"));
        assertFalse(Program.passwordContainsTwoRepeatedPairs("abcd"));
    }
}