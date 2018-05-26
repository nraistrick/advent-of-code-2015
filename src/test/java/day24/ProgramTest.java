package day24;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest
{
    @Test
    void getPresentWeights() throws IOException
    {
        List<String> instructions = Utilities.getFileLines("day24/testinput.txt");
        List<Integer> expected = new ArrayList()
        {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(7);
            add(8);
            add(9);
            add(10);
            add(11);
        }};
        assertEquals(expected, Program.getPresentWeights(instructions));
    }

    @Test
    void findAllCombinationsThatSumTo() throws IOException
    {
        List<Integer> values = new ArrayList()
        {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
        List<List<Integer>> expected = new ArrayList()
        {{
            add(new ArrayList()
            {{
                add(1);
                add(2);
                add(3);
            }});
            add(new ArrayList()
            {{
                add(1);
                add(5);
            }});
            add(new ArrayList()
            {{
                add(2);
                add(4);
            }});
            add(new ArrayList()
            {{
                add(6);
            }});
        }};

        assertEquals(expected, Program.findCombinationsThatSumTo(values, 6));
    }

    @Test
    void calculateSmallestQuantumEntanglement()
    {
        List<List<Integer>> groups = new ArrayList()
        {{
            add(new ArrayList()
            {{
                add(1);
                add(2);
                add(3);
            }});
            add(new ArrayList()
            {{
                add(2);
                add(4);
                add(5);
            }});
            add(new ArrayList()
            {{
                add(3);
                add(5);
                add(9);
            }});
        }};

        assertEquals(6, Program.calculateSmallestQuantumEntanglement(groups));
    }
}
