package day20;

import static java.lang.Math.sqrt;

/**
 * Finds the number of presents delivered to a house from a number
 * of elves delivering in different sequences. The elves now stop
 * delivering presents after visiting 50 houses.
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
        int lowestElfDelivering = (houseNumber + 50 - 1) / 50;
        int elfNumber = 1;

        while (elfNumber <= sqrt(houseNumber))
        {
            int quotient = houseNumber / elfNumber;
            int remainder = houseNumber % elfNumber;

            if (remainder == 0)
            {
                if (elfNumber >= lowestElfDelivering)
                {
                    presentsForHouse += elfNumber;
                }
                if ((quotient >= lowestElfDelivering) && (quotient != elfNumber))
                {
                    presentsForHouse += quotient;
                }
            }

            elfNumber++;
        }

        return presentsForHouse * 11;
    }
}
