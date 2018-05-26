package day23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A basic computer with only two registers
 */
public class MyFirstComputer
{
    private Map<String, Integer> registers;

    private List<String> instructions;

    private final String half       = "hlf";
    private final String triple     = "tpl";
    private final String increment  = "inc";
    private final String jump       = "jmp";
    private final String jumpIfEven = "jie";
    private final String jumpIfOdd  = "jio";

    public MyFirstComputer(List<String> instructions)
    {
        registers = new HashMap();
        registers.put("a", 1);
        registers.put("b", 0);

        this.instructions = instructions;
    }

    public int getValueRegisterA()
    {
        return registers.get("a");
    }

    public int getValueRegisterB()
    {
        return registers.get("b");
    }

    public void execute()
    {
        int i = 0;
        while (i < instructions.size())
        {
            String[] split = instructions.get(i).split(" ");

            switch(split[0])
            {
                case half:
                    registers.put(split[1], registers.get(split[1]) / 2);
                    break;
                case triple:
                    registers.put(split[1], registers.get(split[1]) * 3);
                    break;
                case increment:
                    registers.put(split[1], registers.get(split[1]) + 1);
                    break;
                case jump:
                    i += Integer.parseInt(split[1]) - 1;
                    break;
                case jumpIfEven:
                    if (registers.get(split[1].substring(0, 1)) % 2 == 0) i += Integer.parseInt(split[2]) - 1;
                    break;
                case jumpIfOdd:
                    if (registers.get(split[1].substring(0, 1)) == 1) i += Integer.parseInt(split[2]) - 1;
                    break;
                default:
                    throw new IllegalArgumentException("Could not parse instruction: " + instructions.get(i));
            }

            i++;
        }
    }
}
