package day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void countAllNumbers()
    {
        assertEquals(6, Program.countAllNumbers("[1,2,3]"));
        assertEquals(6, Program.countAllNumbers("{\"a\":2,\"b\":4}"));
        assertEquals(3, Program.countAllNumbers("[[[3]]]"));
        assertEquals(3, Program.countAllNumbers("{\"a\":{\"b\":4},\"c\":-1}"));
        assertEquals(0, Program.countAllNumbers("[-1,{\"a\":1}"));
        assertEquals(0, Program.countAllNumbers("{\"a\":[-1,1]}"));
        assertEquals(0, Program.countAllNumbers("{}"));
        assertEquals(0, Program.countAllNumbers("[]"));
    }

}