package day15;

import common.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use science to calculate the best cookie recipe with the optimum
 * balance of ingredients and a calorie count of 500
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day15/input.txt");
        int highestCookieScore = getHighestScoringCookie(inputData);
        System.out.println("The highest scoring cookie is: " + highestCookieScore);
    }

    public static int getHighestScoringCookie(List<String> inputData)
    {
        Map<String, Ingredient> ingredients = getIngredients(inputData);
        List<String> names = new ArrayList(ingredients.keySet());

        int highestScore = 0;
        for (List<Integer> combination : Utilities.findSumCombinations(100, names.size()))
        {
            for (int i = 0; i < names.size(); i++)
            {
                ingredients.get(names.get(i)).setQuantity(combination.get(i));
            }

            int cookieScore = getCookieScore(ingredients);
            highestScore = Math.max(highestScore, cookieScore);
        }

        return highestScore;
    }

    public static int getCookieScore(Map<String, Ingredient> ingredients)
    {
        List<Integer> ingredientCapacities   = new ArrayList(),
                      ingredientDurabilities = new ArrayList(),
                      ingredientFlavours     = new ArrayList(),
                      ingredientTextures     = new ArrayList(),
                      ingredientCalories     = new ArrayList();

        for (String ingredientName : ingredients.keySet())
        {
            Ingredient i = ingredients.get(ingredientName);

            ingredientCapacities.add   (i.getTotalCapacity());
            ingredientDurabilities.add (i.getTotalDurability());
            ingredientFlavours.add     (i.getTotalFlavour());
            ingredientTextures.add     (i.getTotalTexture());
            ingredientCalories.add     (i.getTotalCalories());
        }

        int capacity   = Math.max(0, ingredientCapacities.stream().mapToInt(Integer::intValue).sum());
        int durability = Math.max(0, ingredientDurabilities.stream().mapToInt(Integer::intValue).sum());
        int flavour    = Math.max(0, ingredientFlavours.stream().mapToInt(Integer::intValue).sum());
        int texture    = Math.max(0, ingredientTextures.stream().mapToInt(Integer::intValue).sum());
        int calories   = Math.max(0, ingredientCalories.stream().mapToInt(Integer::intValue).sum());

        if (calories != 500) return 0;

        return capacity * durability * flavour * texture;
    }

    public static Map<String, Ingredient> getIngredients(List<String> inputData)
    {
        Map<String, Ingredient> ingredients = new HashMap();

        for (String line : inputData)
        {
            String[] split = line.replace(",", "")
                                 .replace(":", "")
                                 .split(" ");

            Ingredient i = new Ingredient(Integer.parseInt(split[2]),
                                          Integer.parseInt(split[4]),
                                          Integer.parseInt(split[6]),
                                          Integer.parseInt(split[8]),
                                          Integer.parseInt(split[10]));

            ingredients.put(split[0], i);
        }

        return ingredients;
    }
}
