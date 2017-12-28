package day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void getNextMove()
    {
        assertEquals("11", Program.getNextMove("1"));
        assertEquals("21", Program.getNextMove("11"));
        assertEquals("1211", Program.getNextMove("21"));
        assertEquals("112211", Program.getNextMove("1221"));
        assertEquals("312211", Program.getNextMove("111221"));
    }

}