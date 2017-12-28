package day13;

import common.Utilities;

import java.io.IOException;
import java.util.*;

/**
 * Calculate the optimum seating arrangement for a set of dinner guests
 * to maximise overall happiness
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day13/input.txt");
        Map<String, Map<String, Integer>> happinessLookup = createHappinessLookup(inputData);

        List<Integer> allHappinessChanges = new ArrayList();
        Set<String> people = happinessLookup.keySet();

        String firstPerson = people.iterator().next();
        Set<String> availableLocations = new TreeSet(people);
        availableLocations.remove(firstPerson);
        allHappinessChanges.addAll(findAllHappinessChanges(happinessLookup, firstPerson, firstPerson, availableLocations));

        int maximumHappinessChange = Collections.max(allHappinessChanges);
        System.out.println(String.format("The maximum available happiness is: %d", maximumHappinessChange));
    }

    public static Map<String, Map<String, Integer>> createHappinessLookup(List<String> inputData)
    {
        Map<String, Map<String, Integer>> locations = new HashMap();

        for (String line: inputData)
        {
            String[] split = line.split(" ");

            String personOne = split[0];
            String personTwo = split[10].replace(".", "");

            int happiness = Integer.parseInt(split[3]);
            if (split[2].equals("lose")) happiness *= -1;

            if (!locations.containsKey(personOne)) locations.put(personOne, new HashMap());

            locations.get(personOne).put(personTwo, happiness);
        }

        return locations;
    }

    public static List<Integer> findAllHappinessChanges(Map<String, Map<String, Integer>> happinessLookup,
                                                        String originalPerson,
                                                        String currentPerson,
                                                        Set<String> availablePeople)
    {
        List<Integer> allHappinessChanges = new ArrayList();

        for (String person : availablePeople)
        {
            int happinessChange = happinessLookup.get(currentPerson).get(person) +
                                  happinessLookup.get(person).get(currentPerson);

            Set<String> otherLocations = new TreeSet(availablePeople);
            otherLocations.remove(person);

            List<Integer> childDistances = findAllHappinessChanges(happinessLookup, originalPerson, person, otherLocations);

            if (childDistances.size() == 0)
            {
                happinessChange += happinessLookup.get(person).get(originalPerson);
                happinessChange += happinessLookup.get(originalPerson).get(person);
                allHappinessChanges.add(happinessChange);
                break;
            }

            for (int i = 0; i < childDistances.size(); i++)
            {
                childDistances.set(i, childDistances.get(i) + happinessChange);
            }

            allHappinessChanges.addAll(childDistances);
        }

        return allHappinessChanges;
    }
}
