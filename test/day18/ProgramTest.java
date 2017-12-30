package day18;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void updateGrid() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day18/testinput.txt");
        Program program = new Program(6, 6, inputData);

        assertEquals(17, program.countOnLights());

        program.updateGrid();
        assertEquals(18, program.countOnLights());

        program.updateGrid();
        assertEquals(18, program.countOnLights());

        program.updateGrid();
        assertEquals(18, program.countOnLights());

        program.updateGrid();
        assertEquals(14, program.countOnLights());
    }
}