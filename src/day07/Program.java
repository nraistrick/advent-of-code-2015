package day07;

import common.Utilities;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Calculates the final value provided to a wire for a circuit made up of
 * a collection of bitwise logic-gates
 */
public class Program
{
    Map<String, String> Instructions;
    Map<String, Integer> CachedValues;

    public Program()
    {
        Instructions = new HashMap();
        CachedValues = new HashMap();
    }

    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day07/input.txt");
        Program program = new Program();
        program.populateHashMap(inputData);
        int value = program.calculateRegisterValue("a");

        System.out.println(String.format("The final register value: %d", value));
    }

    public void populateHashMap(Collection<String> inputData)
    {
        for (String line : inputData)
        {
            String[] split = line.split(" -> ");
            Instructions.put(split[1], split[0]);
        }
    }

    public int calculateRegisterValue(String registerName)
    {
        if (CachedValues.containsKey(registerName)) return CachedValues.get(registerName);

        if (registerName.matches("^-?\\d+$")) return Integer.parseInt(registerName) & 0xFFFF;

        String value = Instructions.get(registerName);
        if (value.matches("^-?\\d+$")) CachedValues.put(registerName, Integer.parseInt(value) & 0xFFFF);

        String[] split = value.split(" ");

        if      (split.length == 1)         CachedValues.put(registerName, calculateRegisterValue(split[0]));
        else if (split[0].equals("NOT"))    CachedValues.put(registerName, ~calculateRegisterValue(split[1]) & 0xFFFF);
        else if (split[1].equals("AND"))    CachedValues.put(registerName, calculateRegisterValue(split[0]) &  calculateRegisterValue(split[2]) & 0xFFFF);
        else if (split[1].equals("OR"))     CachedValues.put(registerName, calculateRegisterValue(split[0]) |  calculateRegisterValue(split[2]) & 0xFFFF);
        else if (split[1].equals("LSHIFT")) CachedValues.put(registerName, calculateRegisterValue(split[0]) << calculateRegisterValue(split[2]) & 0xFFFF);
        else if (split[1].equals("RSHIFT")) CachedValues.put(registerName, calculateRegisterValue(split[0]) >> calculateRegisterValue(split[2]) & 0xFFFF);

        return CachedValues.get(registerName);
    }
}
