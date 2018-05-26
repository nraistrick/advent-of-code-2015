package day03;

/**
 * Models Santa and his robot-counterpart delivering presents to various
 * houses in an infinite two-dimensional grid
 */
public class HouseGrid
{
    private int[][] _houseGrid;
    private int x, y;
    private int xRobot, yRobot;

    public int HousesVisited;

    public HouseGrid()
    {
        int gridLength = 1000;
        _houseGrid = new int[gridLength][gridLength];
        x = y = xRobot = yRobot = gridLength / 2;

        // Always include the starting house as visited
        _houseGrid[x][y] = 1;
        HousesVisited = 1;
    }

    public void followInstructions(String instructions)
    {
        for (int i = 0; i < instructions.length(); i++)
        {
            char c = instructions.charAt(i);
            if (i % 2 == 0) updateLocation(c);
            else            updateRobotLocation(c);
        }
    }

    private void updateLocation(char direction)
    {
        switch (direction)
        {
            case '^': y--; break;
            case 'v': y++; break;
            case '>': x++; break;
            case '<': x--; break;
            default: throw new IllegalArgumentException();
        }

        _houseGrid[x][y] += 1;
        if (_houseGrid[x][y] == 1) HousesVisited += 1;
    }

    private void updateRobotLocation(char direction)
    {
        switch (direction)
        {
            case '^': yRobot--; break;
            case 'v': yRobot++; break;
            case '>': xRobot++; break;
            case '<': xRobot--; break;
            default: throw new IllegalArgumentException();
        }

        _houseGrid[xRobot][yRobot] += 1;
        if (_houseGrid[xRobot][yRobot] == 1) HousesVisited += 1;
    }
}
