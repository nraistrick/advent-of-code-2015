package day03;

/**
 * Models Santa delivering presents to various houses in an infinite
 * two-dimensional grid
 */
public class HouseGrid
{
    private int[][] _houseGrid;
    private int x, y;
    private int roboX, roboY;

    public int HousesVisited;

    public HouseGrid()
    {
        int gridLength = 1000;
        _houseGrid = new int[gridLength][gridLength];
        x = y = roboX = roboY = gridLength / 2;

        // Always include the starting house as visited
        _houseGrid[x][y] = 1;
        HousesVisited = 1;
    }

    public void followInstructions(String instructions)
    {
        for (int i = 0; i < instructions.length(); i++)
        {
            char c = instructions.charAt(i);
            updateLocation(c);
            _houseGrid[x][y] += 1;

            if (_houseGrid[x][y] == 1) HousesVisited += 1;
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
    }
}
