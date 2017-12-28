package day13;

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
    public void createHappinessLookup() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day13/testinput.txt");
        Map<String, Map<String, Integer>> happinessLookup = Program.createHappinessLookup(inputData);

        assertEquals(54,  (int)happinessLookup.get("Alice").get("Bob"));
        assertEquals(-79, (int)happinessLookup.get("Alice").get("Carol"));
        assertEquals(-2,  (int)happinessLookup.get("Alice").get("David"));

        assertEquals(83,  (int)happinessLookup.get("Bob").get("Alice"));
        assertEquals(-7,  (int)happinessLookup.get("Bob").get("Carol"));
        assertEquals(-63, (int)happinessLookup.get("Bob").get("David"));

        assertEquals(-62, (int)happinessLookup.get("Carol").get("Alice"));
        assertEquals(60,  (int)happinessLookup.get("Carol").get("Bob"));
        assertEquals(55,  (int)happinessLookup.get("Carol").get("David"));

        assertEquals(46,  (int)happinessLookup.get("David").get("Alice"));
        assertEquals(-7,  (int)happinessLookup.get("David").get("Bob"));
        assertEquals(41,  (int)happinessLookup.get("David").get("Carol"));
    }

    @Test
    public void findAllHappinessChanges() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day13/testinput.txt");
        Map<String, Map<String, Integer>> happinessLookup = Program.createHappinessLookup(inputData);

        Set<String> locations = new TreeSet(happinessLookup.keySet());
        locations.remove("Alice");
        List<Integer> allDistances = Program.findAllHappinessChanges(happinessLookup, "Alice", "Alice", locations);
        assertArrayEquals(new Integer[] {330, 22, -114, 22, -114, 330}, allDistances.toArray(new Integer[allDistances.size()]));
    }
}