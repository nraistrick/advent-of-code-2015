package day18;

import common.Utilities;

import java.io.IOException;
import java.util.List;

/**
 * Calculate the number of lights switched on in a two-dimensional grid
 * for a holiday-house decorating contest. The number of lights is now limited
 * to 10,000 maximum.
 */
public class Program
{
    boolean[][] grid;

    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day18/input.txt");

        Program program = new Program(100, 100, inputData);
        for (int i = 0; i < 100; i++) program.updateGrid();

        System.out.println("The final number of lights on after animation is " + program.countOnLights());
    }

    public Program(int width, int height, List<String> inputData)
    {
        grid = new boolean[width][height];
        initialiseGrid(inputData);
    }

    public void initialiseGrid(List<String> inputData)
    {
        for (int y = 0; y < inputData.size(); y++)
        {
            for (int x = 0; x < inputData.get(y).length(); x++)
            {
                if      (inputData.get(y).charAt(x) == '#') grid[x][y] = true;
                else if (inputData.get(y).charAt(x) == '.') grid[x][y] = false;
            }
        }
    }

    public void updateGrid()
    {
        boolean[][] copy = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                copy[i][j] = grid[i][j];

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                copy[i][j] = getUpdatedPixelState(i, j);
            }
        }

        grid = copy;
    }

    public boolean getUpdatedPixelState(int x, int y)
    {
        boolean updatedState = grid[x][y];

        int maxX = grid.length;
        int maxY = grid[0].length;

        int onNeighbours = 0;
        for (int i = Math.max(0, x - 1); i < Math.min(x + 2, maxX); i++)
        {
            for (int j = Math.max(0, y - 1); j < Math.min(y + 2, maxY); j++)
            {
                if (i == x && j == y) continue;
                if (grid[i][j] == true) onNeighbours++;
            }
        }

        if (grid[x][y] == true  && onNeighbours != 2 && onNeighbours != 3) updatedState = false;
        if (grid[x][y] == false && onNeighbours == 3)                      updatedState = true;

        return updatedState;
    }

    public int countOnLights()
    {
        int lightsOn = 0;

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == true) lightsOn++;
            }
        }

        return lightsOn;
    }
}
