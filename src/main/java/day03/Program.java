package day03;

import common.Utilities;

import java.io.IOException;

/**
 * Calculate the number of houses in an infinite two-dimensional grid that
 * receive at least one present based on a set of input directions
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        HouseGrid grid = new HouseGrid();
        grid.followInstructions(Utilities.getFileContents("day03/input.txt"));
        System.out.println(String.format("Houses visited at least once is: %d", grid.HousesVisited));
    }
}
