package day23;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest
{
    @Test
    void checkInstructionsExecutedCorrectly() throws IOException
    {
        List<String> instructions = Utilities.getFileLines("day23/testinput.txt");
        MyFirstComputer myFirstComputer = new MyFirstComputer(instructions);
        myFirstComputer.execute();
        assertEquals(2, myFirstComputer.getValueRegisterA());
    }
}
