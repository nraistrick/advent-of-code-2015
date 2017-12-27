package day08;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void countCharacterDifference() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day08/testinput.txt");
        assertEquals(12, Program.countCharacterDifference(inputData));
    }

    @Test
    void countRawCharactersInData() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day08/testinput.txt");
        assertEquals(23, Program.countRawCharactersInData(inputData));
    }

    @Test
    void countInMemoryCharactersInData() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day08/testinput.txt");
        assertEquals(11, Program.countInMemoryCharactersInData(inputData));
    }

    @Test
    void removeRedundantInMemoryCharacters() throws IOException
    {
        assertEquals("v_\"lgs\"kvjfy\\wmut_r",
                     Program.removeRedundantInMemoryCharacters("\"v\\xfb\\\"lgs\\\"kvjfy\\\\wmut\\x9cr\""));
        assertEquals("bidsptalmoicyorbv\\",
                Program.removeRedundantInMemoryCharacters("\"bidsptalmoicyorbv\\\\\""));
        assertEquals("jcrkptrsasjp\\\"cwigzynjgspxxv\\vyb",
                Program.removeRedundantInMemoryCharacters("\"jcrkptrsasjp\\\\\\\"cwigzynjgspxxv\\\\vyb\""));
        assertEquals("x\"_j\\xwwvpdldz",
                Program.removeRedundantInMemoryCharacters("\"x\\\"\\xcaj\\\\xwwvpdldz\""));
    }
}