package day07;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void calculateRegisterValue() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day07/testinput.txt");
        Program program = new Program();
        program.populateHashMap(inputData);
        assertEquals(72,     program.calculateRegisterValue("d"));
        assertEquals(507,    program.calculateRegisterValue("e"));
        assertEquals(492,    program.calculateRegisterValue("f"));
        assertEquals(114,    program.calculateRegisterValue("g"));
        assertEquals(65412,  program.calculateRegisterValue("h"));
        assertEquals(65079,  program.calculateRegisterValue("i"));
        assertEquals(123,    program.calculateRegisterValue("x"));
        assertEquals(456,    program.calculateRegisterValue("y"));
    }
}