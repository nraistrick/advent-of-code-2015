package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseGridTest
{
    @Test
    public void testFollowInstructions()
    {
        HouseGrid grid = new HouseGrid();
        grid.followInstructions("^v");
        assertEquals(3, grid.HousesVisited);

        grid = new HouseGrid();
        grid.followInstructions("^>v<");
        assertEquals(3, grid.HousesVisited);

        grid = new HouseGrid();
        grid.followInstructions("^v^v^v^v^v");
        assertEquals(11, grid.HousesVisited);
    }
}