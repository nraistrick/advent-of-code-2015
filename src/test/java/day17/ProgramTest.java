package day17;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void countPossibleCombinations()
    {
        List<Integer> containers = Arrays.asList(20, 15, 10, 5, 5);
        List<Integer> indexes = IntStream.range(0, containers.size()).boxed().collect(Collectors.toList());
        List<List<Integer>> combinations = Program.countPossibleCombinations(containers, 25, indexes);

        List<List<Integer>> uniqueCombinations = combinations.stream().distinct().collect(Collectors.toList());
        assertEquals(4, uniqueCombinations.size());
    }

    @Test
    void countContainerCombinations()
    {
        List<List<Integer>> containers = new ArrayList();
        containers.add(Arrays.asList(1, 2));
        containers.add(Arrays.asList(2, 3));
        containers.add(Arrays.asList(1, 2, 3));

        assertEquals(2, Program.countContainerCombinations(containers, 2));
    }
}