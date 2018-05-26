package day09;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    public void createLocationLookup() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day09/testinput.txt");
        Map<String, Map<String, Integer>> locationLookup = Program.createHappinessLookup(inputData);

        assertEquals(141, (int)locationLookup.get("Belfast").get("Dublin"));
        assertEquals(518, (int)locationLookup.get("Belfast").get("London"));
        assertEquals(141, (int)locationLookup.get("Dublin").get("Belfast"));
        assertEquals(464, (int)locationLookup.get("Dublin").get("London"));
        assertEquals(518, (int)locationLookup.get("London").get("Belfast"));
        assertEquals(464, (int)locationLookup.get("London").get("Dublin"));
    }

    @Test
    public void findAllDistances() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day09/testinput.txt");
        Map<String, Map<String, Integer>> locationLookup = Program.createHappinessLookup(inputData);

        Set<String> locations = new TreeSet(locationLookup.keySet());
        locations.remove("London");
        List<Integer> allDistances = Program.findAllDistances(locationLookup, "London", locations);
        assertArrayEquals(new Integer[] {659, 605}, allDistances.toArray(new Integer[allDistances.size()]));

        locations = new TreeSet(locationLookup.keySet());
        locations.remove("Belfast");
        allDistances = Program.findAllDistances(locationLookup, "Belfast", locations);
        assertArrayEquals(new Integer[] {605, 982}, allDistances.toArray(new Integer[allDistances.size()]));

        locations = new TreeSet(locationLookup.keySet());
        locations.remove("Dublin");
        allDistances = Program.findAllDistances(locationLookup, "Dublin", locations);
        assertArrayEquals(new Integer[] {659, 982}, allDistances.toArray(new Integer[allDistances.size()]));
    }
}