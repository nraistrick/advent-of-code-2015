package day06;

import common.Utilities;

import java.io.IOException;
import java.util.List;

/**
 * Calculates the number of lights lit in a large grid as part of a house
 * decorating contest
 */
public class Program
{
    boolean[][] grid;

    public Program()
    {
        grid = new boolean[1000][1000];
    }

    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day06/input.txt");

        Program program = new Program();
        program.runInstructions(inputData);
        System.out.println(String.format("The number of lights left on is: %d", program.calculateLightsOn()));
    }

    public int calculateLightsOn()
    {
        int lightsOn = 0;

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j]) lightsOn++;
            }
        }

        return lightsOn;
    }

    public void runInstructions(List<String> instructions)
    {
        for (String i: instructions) runInstruction(i);
    }

    public void runInstruction(String instruction)
    {
        String[] s = instruction.split("[\\s,]");
        int startX = Integer.parseInt(s[s.length - 5]);
        int startY = Integer.parseInt(s[s.length - 4]);
        int endX   = Integer.parseInt(s[s.length - 2]);
        int endY   = Integer.parseInt(s[s.length - 1]);

        if      (instruction.startsWith("turn on"))  switchLightsOn (startX, startY, endX, endY);
        else if (instruction.startsWith("turn off")) switchLightsOff(startX, startY, endX, endY);
        else if (instruction.startsWith("toggle"))   toggleLights   (startX, startY, endX, endY);
        else throw new IllegalArgumentException("Could not understand instruction");
    }

    public void switchLightsOn(int startX, int startY, int endX, int endY)
    {
        for (int i = startX; i <= endX; i++)
        {
            for (int j = startY; j <= endY; j++)
            {
                grid[i][j] = true;
            }
        }
    }

    public void switchLightsOff(int startX, int startY, int endX, int endY)
    {
        for (int i = startX; i <= endX; i++)
        {
            for (int j = startY; j <= endY; j++)
            {
                grid[i][j] = false;
            }
        }
    }

    public void toggleLights(int startX, int startY, int endX, int endY)
    {
        for (int i = startX; i <= endX; i++)
        {
            for (int j = startY; j <= endY; j++)
            {
                grid[i][j] = !grid[i][j];
            }
        }
    }
}
