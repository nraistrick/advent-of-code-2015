package day20;

import static java.lang.Math.sqrt;

/**
 * Finds the number of presents delivered to a house from a number
 * of elves delivering in different sequences
 */
public class Program
{
    public static void main(String[] args)
    {
        int puzzleInput = 34000000;
        System.out.println("The house number is: " + calculateLowestHouseNumber(puzzleInput));
    }

    public static int calculateLowestHouseNumber(int presentsDelivered)
    {
        int houseNumber = 1;
        while (calculatePresentsForHouse(houseNumber) < presentsDelivered)
        {
            houseNumber++;
        }

        return houseNumber;
    }

    public static int calculatePresentsForHouse(int houseNumber)
    {
        int presentsForHouse = 0;
        int elfNumber = 1;

        while (elfNumber <= sqrt(houseNumber))
        {
            int quotient = houseNumber / elfNumber;
            int remainder = houseNumber % elfNumber;

            if (remainder == 0)
            {
                presentsForHouse += elfNumber;
                if (quotient != elfNumber)
                {
                    presentsForHouse += quotient;
                }
            }

            elfNumber++;
        }

        return presentsForHouse * 10;
    }
}
