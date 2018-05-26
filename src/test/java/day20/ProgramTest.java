package day20;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void calculateDeliveredPresents() throws IOException
    {
        assertEquals(11, Program.calculatePresentsForHouse(1));
        assertEquals(33, Program.calculatePresentsForHouse(2));
        assertEquals(44, Program.calculatePresentsForHouse(3));
        assertEquals(77, Program.calculatePresentsForHouse(4));
        assertEquals(66, Program.calculatePresentsForHouse(5));
        assertEquals(132, Program.calculatePresentsForHouse(6));
        assertEquals(88, Program.calculatePresentsForHouse(7));
        assertEquals(165, Program.calculatePresentsForHouse(8));
        assertEquals(143, Program.calculatePresentsForHouse(9));
    }

    @Test
    void calculateHouseThatReceivesThisNumberOfPresents() throws IOException
    {
        assertEquals(1, Program.calculateLowestHouseNumber(10));
        assertEquals(3, Program.calculateLowestHouseNumber(40));
        assertEquals(4, Program.calculateLowestHouseNumber(60));
        assertEquals(6, Program.calculateLowestHouseNumber(130));
    }
}