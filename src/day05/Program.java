package day05;

import common.Utilities;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Calculates the number of nice strings on Santa's naughty or nice list
 */
public class Program
{
    private static final String[] _invalidStrings = {"ab", "cd", "pq", "xy"};

    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day05/input.txt");
        System.out.println(String.format("The number of nice strings is: %d", countNumberOfNiceStrings(inputData)));

    }

    public static int countNumberOfNiceStrings(Collection<String> inputData)
    {
        int niceStrings = 0;

        for (String line : inputData)
        {
            if (isOnNiceList(line)) niceStrings++;
        }

        return niceStrings;
    }

    public static boolean isOnNiceList(String input)
    {
        return containsThreeVowels(input) &&
               containsRepeatedLetter(input) &&
               !containsInvalidString(input);
    }

    public static boolean containsThreeVowels(String input)
    {
        int numberOfVowels = input.length() - input.replaceAll("[aeiou]", "").length();

        return (numberOfVowels >= 3);
    }

    public static boolean containsRepeatedLetter(String input)
    {
        for (int i = 0; i < input.length() - 1; i++)
        {
            if (input.charAt(i) == input.charAt(i + 1)) return true;
        }

        return false;
    }

    public static boolean containsInvalidString(String input)
    {
        for (String invalid : _invalidStrings)
        {
            if (input.contains(invalid)) return true;
        }

        return false;
    }
}
