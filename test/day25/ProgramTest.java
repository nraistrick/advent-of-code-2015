package day25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest
{
    @Test
    void getValueInDiagonalGrid()
    {
        assertEquals(1, Program.calculateNumberInSequence(1, 1));
        assertEquals(2, Program.calculateNumberInSequence(2, 1));
        assertEquals(3, Program.calculateNumberInSequence(1, 2));
        assertEquals(10, Program.calculateNumberInSequence(1, 4));
        assertEquals(13, Program.calculateNumberInSequence(3, 3));
        assertEquals(17, Program.calculateNumberInSequence(5, 2));
    }

    @Test
    void calculateCodeAtValue()
    {
        assertEquals(31916031, Program.calculateCodeAt(2, 20151125));
        assertEquals(30943339, Program.calculateCodeAt(10, 20151125));
    }

    @Test
    void calculateNextCode()
    {
        assertEquals(31916031, Program.calculateNextCode(20151125));
    }
}
