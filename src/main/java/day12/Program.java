package day12;

import common.Utilities;

import java.io.IOException;

/**
 * Calculate the sum of numbers in an erroneous javascript document produced
 * by software used by Santa's accounting-elves. Ignore any object (and its
 * children) that contains a property with the value "red".
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        String document = Utilities.getFileContents("day12/input.txt");
        int numberCount = countAllNumbers(document);
        System.out.println("The total sum of all numbers in the document is: " + numberCount);

        String cleanedDocument = cleanJson(document);
        numberCount = countAllNumbers(cleanedDocument);
        System.out.println("The total sum of all numbers in the cleaned document is: " + numberCount);

    }

    public static int countAllNumbers(String document)
    {
        int total = 0;
        StringBuilder buffer = new StringBuilder();

        for (char c : document.toCharArray())
        {
            if (Character.isDigit(c) || c == '-')
            {
                buffer.append(c);
                continue;
            }

            if (buffer.length() > 0)
            {
                total += Integer.parseInt(buffer.toString());
                buffer.setLength(0);
            }
        }

        return total;
    }

    public static String cleanJson(String document)
    {
        String illegal = "red";

        while (true)
        {
            int objectToRemoveIndex = document.indexOf(illegal);
            if (objectToRemoveIndex == -1) break;

            String context = document.substring(objectToRemoveIndex - 2, objectToRemoveIndex);
            if (context.equals(",\"") || context.equals("[\""))
            {
                StringBuilder builder = new StringBuilder(document);
                builder.replace(objectToRemoveIndex, objectToRemoveIndex + illegal.length(), "");
                document = builder.toString();
                continue;
            }

            document = removeContainingObject(document, objectToRemoveIndex);
        }

        return document;
    }

    public static String removeContainingObject(String document, int index)
    {
        StringBuilder builder = new StringBuilder(document);

        int leftBraceIndex = getLeftEnclosingObjectBrace(document, index);
        int rightBraceIndex = getRightEnclosingObjectBrace(document, index);
        builder.replace(leftBraceIndex, rightBraceIndex + 1,"");

        return builder.toString();
    }

    public static int getLeftEnclosingObjectBrace(String document, int index)
    {
        int braceCounter = 0;
        int i;

        for (i = index; i > 0; i--)
        {
            if      (document.charAt(i) == '{' && braceCounter == 0) break;
            else if (document.charAt(i) == '}') braceCounter++;
            else if (document.charAt(i) == '{') braceCounter--;
        }

        if (document.charAt(i) != '{') throw new IllegalArgumentException();

        return i;
    }

    public static int getRightEnclosingObjectBrace(String document, int index)
    {
        int braceCounter = 0;
        int i;

        for (i = index; i < document.length(); i++)
        {
            if      (document.charAt(i) == '}' && braceCounter == 0) break;
            else if (document.charAt(i) == '{') braceCounter++;
            else if (document.charAt(i) == '}') braceCounter--;
        }

        if (document.charAt(i) != '}') throw new IllegalArgumentException();

        return i;
    }
}
