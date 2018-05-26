package day24;

import common.Utilities;

import java.io.IOException;
import java.util.*;

/**
 * A program to calculate the optimum distribution of packages
 * between a number of areas of Santa's sleigh
 */
public class Program
{
    private static final int NUMBER_OF_SLEIGH_AREAS = 4;

    public static void main(String[] args) throws IOException
    {
        List<String> input = Utilities.getFileLines("day24/input.txt");
        List<Integer> presentWeights = getPresentWeights(input);

        final int totalPresentWeight = presentWeights.stream().mapToInt(Integer::intValue).sum();
        final int weightPerGroup = totalPresentWeight / NUMBER_OF_SLEIGH_AREAS;

        List<List<Integer>> combinations = findCombinationsThatSumTo(presentWeights, weightPerGroup);

        // Get a collection of combinations with the smallest number of presents;
        // these are the ones we are interested in as they provide
        // the most room in the main compartment.
        Collections.sort(combinations, Comparator.comparingInt(List::size));
        List<List<Integer>> smallestCombinations = new ArrayList(combinations);
        int minimumSize = smallestCombinations.get(0).size();
        smallestCombinations.removeIf(c -> c.size() > minimumSize);

        // Find the smallest quantum entanglement of any of these present combinations
        long quantumEntanglement = calculateSmallestQuantumEntanglement(smallestCombinations);
        System.out.println("The group with the smallest quantum entanglement is: " + quantumEntanglement);
    }

    /**
     * Get's the provided present weights as a list of integers
     */
    public static List<Integer> getPresentWeights(List<String> input)
    {
        List<Integer> presentWeights = new ArrayList();
        for (String line : input)
        {
            presentWeights.add(Integer.parseInt(line));
        }

        return presentWeights;
    }

    /**
     * Finds all combinations of numbers that can be added together to produce
     * a given sum
     * @param possibleValues The possible values
     * @param sum The expected total
     * @return All possible combinations of values
     */
    public static List<List<Integer>> findCombinationsThatSumTo(List<Integer> possibleValues, int sum)
    {
        return findCombinationsThatSumTo(possibleValues, sum, new ArrayList());
    }

    private static List<List<Integer>> findCombinationsThatSumTo(List<Integer> possibleValues,
                                                                 int sum,
                                                                 List<Integer> currentCombination)
    {
        List<List<Integer>> combinations = new ArrayList();

        List<Integer> presentValues = new ArrayList(possibleValues);
        for (int i = 0; i < presentValues.size(); i++)
        {
            int currentTotal = currentCombination.stream().mapToInt(Integer::intValue).sum() + presentValues.get(i);
            if (currentTotal == sum)
            {
                List<Integer> validCombination = new ArrayList(currentCombination);
                validCombination.add(presentValues.get(i));
                combinations.add(validCombination);
                break;
            }
            else if (currentTotal > sum)
            {
                break;
            }
            else
            {
                List<Integer> newCombination = new ArrayList(currentCombination);
                newCombination.add(presentValues.get(i));

                List<Integer> remainingValues = new ArrayList(presentValues);
                remainingValues.remove(i);

                combinations.addAll(findCombinationsThatSumTo(remainingValues, sum, newCombination));
            }

            presentValues.remove(i);
            i--;
        }

        return combinations;
    }

    /**
     * Retrieves the smallest quantum entanglement from the collection of
     * provided groups. Quantum entanglement is defined as the total product of
     * all the weights in a group i.e. all the weights multiplied by each other.
     *
     * @param groups The possible groupings of present weights
     * @return The lowest quantum entanglement value
     */
    public static long calculateSmallestQuantumEntanglement(List<List<Integer>> groups)
    {
        long smallestQuantumEntanglement = 0;

        for (List<Integer> group : groups)
        {
            long quantumEntanglement = 1;
            for (int value : group) quantumEntanglement *= value;

            if (smallestQuantumEntanglement == 0 || quantumEntanglement < smallestQuantumEntanglement)
            {
                smallestQuantumEntanglement = quantumEntanglement;
            }
        }

        return smallestQuantumEntanglement;
    }
}
