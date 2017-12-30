package day17;

import common.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Calculate the number of container combinations that can be used to hold
 * a large amount of eggnog
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day17/input.txt");
        List<Integer> containers = new ArrayList();
        for(String s : inputData) containers.add(Integer.valueOf(s));

        List<Integer> indexes = IntStream.range(0, containers.size()).boxed().collect(Collectors.toList());
        List<List<Integer>> possibleCombinations = countPossibleCombinations(containers, 150, indexes);
        List<List<Integer>> uniqueCombinations = possibleCombinations.stream().distinct().collect(Collectors.toList());

        System.out.println("The number of possible combinations is: " + uniqueCombinations.size());
    }

    public static List<List<Integer>> countPossibleCombinations(List<Integer> containers,
                                                                int total,
                                                                List<Integer> remainingContainerIndexes)
    {
        List<List<Integer>> possibleCombinations = new ArrayList(new ArrayList());

        for (int i : remainingContainerIndexes)
        {
            int remainingTotal = total - containers.get(i);
            if (remainingTotal == 0)
            {
                List<Integer> combination = new ArrayList();
                for (int j = 0; j < containers.size(); j++)
                {
                    if (!remainingContainerIndexes.contains(j)) combination.add(j);
                }

                combination.add(i);
                Collections.sort(combination);
                possibleCombinations.add(combination);
            }
            else if (remainingTotal > 0)
            {
                List<Integer> remaining = new ArrayList(remainingContainerIndexes);
                remaining.remove((Integer)i);
                possibleCombinations.addAll(countPossibleCombinations(containers, remainingTotal, remaining));
            }
        }

        return possibleCombinations;
    }
}
