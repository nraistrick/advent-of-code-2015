package day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void getPresentDimensions()
    {
        Present present = new Present("2x3x4");
        assertEquals(2, present.Height);
        assertEquals(3, present.Width);
        assertEquals(4, present.Length);
    }

    @Test
    void calculateRequiredPaper()
    {
        assertEquals(58, new Present(2, 3, 4).calculateRequiredPaper());
        assertEquals(43, new Present(1, 1, 10).calculateRequiredPaper());
    }

    @Test
    void calculateTotalPaper()
    {
        assertEquals(101, Program.calculateTotalPaper(Arrays.asList("2x3x4", "1x1x10")));
    }
}