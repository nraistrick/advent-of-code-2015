package day25;

/**
 * Program to calculate the security code for a weather machine
 * based on an infinite sequence of generated numbers
 */
public class Program
{
    public static void main(String[] args)
    {
        int numberInSequence = calculateNumberInSequence(3010, 3019);
        long codeAtNumber = calculateCodeAt(numberInSequence, 20151125);

        System.out.println("The code at the specified row and column is: " + codeAtNumber);
    }

    /**
     * Calculate what number is placed at a specific location on an infinite
     * code grid
     */
    public static int calculateNumberInSequence(int row, int column)
    {
        int i = 1, j = 1;
        int number = 1;
        while (i != row || j != column)
        {
            if (i == 1)
            {
                i = j + 1;
                j = 1;
            }
            else
            {
                i--;
                j++;
            }

            number++;
        }

        return number;
    }

    /**
     * Calculate the code for a specific value in the sequence
     */
    public static long calculateCodeAt(int number, int startingCode)
    {
        long currentCode = startingCode;
        for (int i = 1; i < number; i++)
        {
            currentCode = calculateNextCode(currentCode);
        }

        return currentCode;
    }

    /**
     * Calculate the next code based off the previous value
     */
    public static long calculateNextCode(long currentValue)
    {
        return (currentValue * 252533) % 33554393;
    }
}
