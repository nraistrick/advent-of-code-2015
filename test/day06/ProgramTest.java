package day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    public void runInstruction()
    {
        Program program = new Program();
        program.runInstruction("turn on 0,0 through 999,999");
        assertEquals(1000000, program.calculateLightsOn());

        program.runInstruction("toggle 0,0 through 999,0");
        assertEquals(999000, program.calculateLightsOn());

        program.runInstruction("turn off 499,499 through 500,500");
        assertEquals(998996, program.calculateLightsOn());
    }
}