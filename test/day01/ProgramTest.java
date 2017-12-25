package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void calculateFinalFloor()
    {
        assertEquals(0,  Program.calculateFinalFloor("(())"));
        assertEquals(0,  Program.calculateFinalFloor("()()"));
        assertEquals(3,  Program.calculateFinalFloor("((("));
        assertEquals(3,  Program.calculateFinalFloor("(()(()("));
        assertEquals(3,  Program.calculateFinalFloor("))((((("));
        assertEquals(-1, Program.calculateFinalFloor("))("));
        assertEquals(-3, Program.calculateFinalFloor(")))"));
        assertEquals(-3, Program.calculateFinalFloor(")())())"));
    }

    @Test
    void findFirstBasementInstruction()
    {
        assertEquals(1,  Program.findFirstBasementInstruction(")"));
        assertEquals(5,  Program.findFirstBasementInstruction("()())"));
    }
}