package day08;

import common.Utilities;

import java.io.IOException;
import java.util.List;

/**
 * Calculate storage information for a digitally encoded version of Santa's
 * present list
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day08/input.txt");
        int difference = countCharacterDifference(inputData);
        System.out.println(String.format("The character difference between raw and in-memory is: %d", difference));

        difference = countEncodedCharacterDifference(inputData);
        System.out.println(String.format("The character difference between raw and encoded is: %d", difference));
    }

    public static int countCharacterDifference(List<String> inputData)
    {
        int rawCharacters = countRawCharactersInData(inputData);
        int inMemoryCharacters = countInMemoryCharactersInData(inputData);

        return rawCharacters - inMemoryCharacters;
    }

    public static int countEncodedCharacterDifference(List<String> inputData)
    {
        int rawCharacters = countRawCharactersInData(inputData);
        int encodedCharacters = countEncodedCharacters(inputData);

        return encodedCharacters - rawCharacters;
    }

    public static int countRawCharactersInData(List<String> inputData)
    {
        int total = 0;
        for (String line: inputData) total += line.length();

        return total;
    }

    public static int countInMemoryCharactersInData(List<String> inputData)
    {
        int total = 0;
        for (String line: inputData) total += removeRedundantInMemoryCharacters(line).length();

        return total;
    }

    public static int countEncodedCharacters(List<String> inputData)
    {
        int total = 0;
        for (String line : inputData)
        {
            total += encodeString(line).length();

            total += 2; // Add enclosing quotes
        }

        return total;
    }

    public static String removeRedundantInMemoryCharacters(String rawInput)
    {
        String inMemory = rawInput;

        // Remove enclosing quotes
        inMemory = inMemory.substring(1, rawInput.length() - 1);

        StringBuilder builder = new StringBuilder(inMemory);
        int skippedBackslashes = 0;

        while (true)
        {
            int backslashIndex = Utilities.nthIndexOf(builder.toString(), "\\", skippedBackslashes + 1);
            if (backslashIndex == -1 || backslashIndex == builder.length() - 1) break;

            switch (builder.charAt(backslashIndex + 1))
            {
                case 'x':
                    builder.replace(backslashIndex, backslashIndex + 4, "_");
                    break;
                case '"':
                    builder.replace(backslashIndex, backslashIndex + 2, "\"");
                    break;
                case '\\':
                    builder.replace(backslashIndex, backslashIndex + 2, "\\");
                    skippedBackslashes += 1;
                    break;
                default:
                    skippedBackslashes += 1;
            }
        }

        return builder.toString();
    }

    public static String encodeString(String inputText)
    {
        inputText = inputText.replace("\\", "\\\\");
        inputText = inputText.replace("\"", "\\\"");

        StringBuilder builder = new StringBuilder(inputText);

        return inputText;
    }
}
