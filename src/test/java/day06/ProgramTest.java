package day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    public void runInstruction()
    {
        Program program = new Program();
        program.runInstruction("toggle 0,0 through 999,999");
        assertEquals(2000000, program.calculateTotalBrightness());

        program = new Program();
        program.runInstruction("turn on 0,0 through 0,0");
        assertEquals(1, program.calculateTotalBrightness());
    }
}