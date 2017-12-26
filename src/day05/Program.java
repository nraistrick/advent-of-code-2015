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
        System.out.println(String.format("The number of nice strings on the improved list is: %d",
                                         countNumberOfImprovedNiceStrings(inputData)));
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

    public static int countNumberOfImprovedNiceStrings(Collection<String> inputData)
    {
        int niceStrings = 0;

        for (String line : inputData)
        {
            if (isOnImprovedNiceList(line)) niceStrings++;
        }

        return niceStrings;
    }

    public static boolean isOnNiceList(String input)
    {
        return containsThreeVowels(input) &&
               containsRepeatedLetter(input) &&
               !containsInvalidString(input);
    }

    public static boolean isOnImprovedNiceList(String input)
    {
        return containsNonOverlappingRepeatedLetters(input) &&
               containsRepeatingSequence(input);
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

    public static boolean containsNonOverlappingRepeatedLetters(String input)
    {
        for (int i = 0; i < input.length() - 1; i++)
        {
            String currentSection = input.substring(i, i + 2);
            String restOfString   = input.substring(i + 2);

            if (restOfString.contains(currentSection)) return true;
        }

        return false;
    }

    public static boolean containsRepeatingSequence(String input)
    {
        for (int i = 0; i < input.length() - 2; i++)
        {
            if (input.charAt(i) == input.charAt(i + 2)) return true;
        }

        return false;
    }
}
