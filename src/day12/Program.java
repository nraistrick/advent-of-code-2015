package day12;


import common.Utilities;

import java.io.IOException;

/**
 * Calculate the sum of numbers in an erroneous javascript document produced
 * by software used by Santa's accounting-elves
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        String document = Utilities.getFileContents("day12/input.txt");
        int numberCount = countAllNumbers(document);
        System.out.println("The total sum of all numbers in the document is: " + numberCount);
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
}
