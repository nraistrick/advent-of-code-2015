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

        int firstBasementEntry = findFirstBasementInstruction(contents);
        System.out.println(String.format("Santa firsts enters the basement at character: %s", firstBasementEntry));
    }

    public static int calculateFinalFloor(String instructions)
    {
        int currentFloor = 0;

        for (int i = 0; i < instructions.length(); i++)
        {
            currentFloor = MoveFloor(currentFloor, instructions.charAt(i));
        }

        return currentFloor;
    }

    public static int findFirstBasementInstruction(String instructions)
    {
        int currentFloor = 0;

        for (int i = 0; i < instructions.length(); i++)
        {
            currentFloor = MoveFloor(currentFloor, instructions.charAt(i));
            if (currentFloor == -1) return i + 1;
        }

        throw new IllegalArgumentException("Instructions never lead Santa to the basement");
    }

    private static int MoveFloor(int currentFloor, char instruction)
    {
        if      (instruction == Up)   currentFloor++;
        else if (instruction == Down) currentFloor--;
        else throw new IllegalArgumentException("Couldn't recognise character in provided instructions");

        return currentFloor;
    }
}
