package day23;

import common.Utilities;

import java.io.IOException;
import java.util.List;

/**
 * A program to simulate the operations of a series instructions
 * in a basic computer with only two registers
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day23/instructions.txt");
        MyFirstComputer myFirstComputer = new MyFirstComputer(inputData);
        myFirstComputer.execute();

        System.out.println("The final value of register b is: " + myFirstComputer.getValueRegisterB());
    }
}
