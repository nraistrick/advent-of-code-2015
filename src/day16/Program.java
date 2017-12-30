package day16;

import common.Utilities;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculate the correct 'Aunt Sue' from a selection of 500 Aunts with the
 * same name
 */
public class Program
{
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException
    {
        AuntSue auntSue = new AuntSue();
        auntSue.Children = 3;
        auntSue.Cats = 7;
        auntSue.Samoyeds = 2;
        auntSue.Pomeranians = 3;
        auntSue.Akitas = 0;
        auntSue.Vizslas = 0;
        auntSue.Goldfish = 5;
        auntSue.Trees = 3;
        auntSue.Cars = 2;
        auntSue.Perfumes = 1;

        List<String> inputData = Utilities.getFileLines("day16/input.txt");
        List<AuntSue> possibleAunts = getPossibleAunts(inputData);
        int matchingAuntSue = findMatchingAuntSue(auntSue, possibleAunts);

        System.out.println("The Aunt Sue that matches the description is: " + matchingAuntSue);
    }

    public static List<AuntSue> getPossibleAunts(List<String> inputData) throws NoSuchFieldException, IllegalAccessException
    {
        List<AuntSue> possibleAunts = new ArrayList();
        for (String line : inputData)
        {
            String[] split = line.replace(":", "").replace(",", "").split(" ");
            AuntSue auntSue = new AuntSue();

            Class<?> c = auntSue.getClass();

            Field f = c.getDeclaredField(Utilities.capitaliseFirstLetter(split[2]));
            f.set(auntSue, Integer.parseInt(split[3]));

            f = c.getDeclaredField(Utilities.capitaliseFirstLetter(split[4]));
            f.set(auntSue, Integer.parseInt(split[5]));

            f = c.getDeclaredField(Utilities.capitaliseFirstLetter(split[6]));
            f.set(auntSue, Integer.parseInt(split[7]));

            possibleAunts.add(auntSue);
        }

        return possibleAunts;
    }

    public static int findMatchingAuntSue(AuntSue auntSue, List<AuntSue> possibleAuntSues)
    {
        for (int i = 0; i < possibleAuntSues.size(); i++)
        {
            if (possibleAuntSues.get(i).Children    != null && auntSue.Children    != possibleAuntSues.get(i).Children)    continue;
            if (possibleAuntSues.get(i).Cats        != null && auntSue.Cats        != possibleAuntSues.get(i).Cats)        continue;
            if (possibleAuntSues.get(i).Samoyeds    != null && auntSue.Samoyeds    != possibleAuntSues.get(i).Samoyeds)    continue;
            if (possibleAuntSues.get(i).Pomeranians != null && auntSue.Pomeranians != possibleAuntSues.get(i).Pomeranians) continue;
            if (possibleAuntSues.get(i).Akitas      != null && auntSue.Akitas      != possibleAuntSues.get(i).Akitas)      continue;
            if (possibleAuntSues.get(i).Vizslas     != null && auntSue.Vizslas     != possibleAuntSues.get(i).Vizslas)     continue;
            if (possibleAuntSues.get(i).Goldfish    != null && auntSue.Goldfish    != possibleAuntSues.get(i).Goldfish)    continue;
            if (possibleAuntSues.get(i).Trees       != null && auntSue.Trees       != possibleAuntSues.get(i).Trees)       continue;
            if (possibleAuntSues.get(i).Cars        != null && auntSue.Cars        != possibleAuntSues.get(i).Cars)        continue;
            if (possibleAuntSues.get(i).Perfumes    != null && auntSue.Perfumes    != possibleAuntSues.get(i).Perfumes)    continue;

            return i + 1;
        }

        throw new IllegalArgumentException("Could not find matching Aunt Sue");
    }
}
