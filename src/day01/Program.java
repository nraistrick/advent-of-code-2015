package day01;

import common.Utilities;

import java.io.IOException;

/**
 * Calculates the floor of an apartment building Santa will get to if
 * he follows a sequence of up and down instructions
 */
public class Program
{
    private static final char Up   = '(';
    private static final char Down = ')';

    public static void main(String[] args) throws IOException
    {
        String contents = Utilities.getFileContents("day01/input.txt");

        int floor = calculateFinalFloor(contents);
        System.out.println(String.format("The floor Santa ends up on is: %s", floor));
    }

    public static int calculateFinalFloor(String instructions)
    {
        int currentFloor = 0;

        for (int i = 0; i < instructions.length(); i++)
        {
            if      (instructions.charAt(i) == Up)   currentFloor++;
            else if (instructions.charAt(i) == Down) currentFloor--;
            else throw new IllegalArgumentException("Couldn't recognise character in provided instructions");
        }

        return currentFloor;
    }
}
