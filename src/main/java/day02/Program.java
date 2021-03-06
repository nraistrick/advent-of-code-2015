package day02;

import common.Utilities;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Calculates the amount of wrapping paper and ribbon the elves need to wrap a
 * group of remaining presents
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day02/input.txt");
        int total = calculateTotalPaper(inputData);
        System.out.println(String.format("The total paper required is: %d", total));

        int ribbonTotal = calculateTotalRibbon(inputData);
        System.out.println(String.format("The total ribbon required is: %d", ribbonTotal));
    }

    public static int calculateTotalPaper(Collection<String> inputData)
    {
        int requiredPaper = 0;

        for (String dimensions : inputData)
        {
            requiredPaper += new Present(dimensions).calculateRequiredPaper();
        }

        return requiredPaper;
    }

    public static int calculateTotalRibbon(Collection<String> inputData)
    {
        int requiredRibbon = 0;

        for (String dimensions : inputData)
        {
            requiredRibbon += new Present(dimensions).calculateRequiredRibbon();
        }

        return requiredRibbon;
    }
}
