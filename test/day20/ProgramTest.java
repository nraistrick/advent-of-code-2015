package day20;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void calculateDeliveredPresents() throws IOException
    {
        assertEquals(10, Program.calculatePresentsForHouse(1));
        assertEquals(30, Program.calculatePresentsForHouse(2));
        assertEquals(40, Program.calculatePresentsForHouse(3));
        assertEquals(70, Program.calculatePresentsForHouse(4));
        assertEquals(60, Program.calculatePresentsForHouse(5));
        assertEquals(120, Program.calculatePresentsForHouse(6));
        assertEquals(80, Program.calculatePresentsForHouse(7));
        assertEquals(150, Program.calculatePresentsForHouse(8));
        assertEquals(130, Program.calculatePresentsForHouse(9));
    }

    @Test
    void calculateHouseThatReceivesThisNumberOfPresents() throws IOException
    {
        assertEquals(1, Program.calculateLowestHouseNumber(10));
        assertEquals(3, Program.calculateLowestHouseNumber(40));
        assertEquals(4, Program.calculateLowestHouseNumber(60));
        assertEquals(8, Program.calculateLowestHouseNumber(130));
    }
}