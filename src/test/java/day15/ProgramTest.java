package day15;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static day15.Program.getIngredients;
import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void getHighestScoringCookie() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day15/testinput.txt");
        assertEquals(57600000, Program.getHighestScoringCookie(inputData));
    }

    @Test
    void getCookieScore() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day15/testinput.txt");
        Map<String, Ingredient> ingredients = getIngredients(inputData);
        ingredients.get("Butterscotch").setQuantity(40);
        ingredients.get("Cinnamon").setQuantity(60);

        assertEquals(57600000, Program.getCookieScore(ingredients));
    }
}