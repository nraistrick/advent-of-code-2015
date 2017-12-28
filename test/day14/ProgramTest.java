package day14;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void getMaxDistanceTravelled() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day14/testinput.txt");
        List<Reindeer> reindeer = Program.createReindeer(inputData);
        int maxDistance = Program.getMaxDistanceTravelled(reindeer, 1000);
        assertEquals(1120, maxDistance);
    }
}