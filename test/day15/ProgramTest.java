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
        assertEquals(62842880, Program.getHighestScoringCookie(inputData));
    }

    @Test
    void getCookieScore() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day15/testinput.txt");
        Map<String, Ingredient> ingredients = getIngredients(inputData);
        ingredients.get("Butterscotch").setQuantity(44);
        ingredients.get("Cinnamon").setQuantity(56);

        assertEquals(62842880, Program.getCookieScore(ingredients));
    }
}