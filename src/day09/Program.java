package day09;

import common.Utilities;

import java.io.IOException;
import java.util.*;

/**
 * Find the shortest and longest distances Santa can travel to deliver
 * presents to several new locations
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day09/input.txt");
        Map<String, Map<String, Integer>> travelDistanceLookup = createLocationLookup(inputData);

        List<Integer> allDistances = new ArrayList();
        Set<String> locations = travelDistanceLookup.keySet();

        for (String startLocation : locations)
        {
            Set<String> availableLocations = new TreeSet(locations);
            availableLocations.remove(startLocation);
            allDistances.addAll(findAllDistances(travelDistanceLookup, startLocation, availableLocations));
        }

        int shortestAvailableDistance = Collections.min(allDistances);
        System.out.println(String.format("The shortest available distance is: %d", shortestAvailableDistance));

        int maximumAvailableDistance = Collections.max(allDistances);
        System.out.println(String.format("The maximum available distance is: %d", maximumAvailableDistance));
    }

    public static Map<String, Map<String, Integer>> createLocationLookup(List<String> inputData)
    {
        Map<String, Map<String, Integer>> locations = new HashMap();

        for (String line: inputData)
        {
            String[] split = line.split(" ");
            String locationOne = split[0];
            String locationTwo = split[2];
            int distance = Integer.parseInt(split[4]);

            if (!locations.containsKey(locationOne)) locations.put(locationOne, new HashMap());
            if (!locations.containsKey(locationTwo)) locations.put(locationTwo, new HashMap());

            locations.get(locationOne).put(locationTwo, distance);
            locations.get(locationTwo).put(locationOne, distance);
        }

        return locations;
    }

    public static List<Integer> findAllDistances(Map<String, Map<String, Integer>> distanceLookup,
                                                 String currentLocation,
                                                 Set<String> availableLocations)
    {
        List<Integer> allDistances = new ArrayList();

        for (String destination : availableLocations)
        {
            int distanceTravelled = distanceLookup.get(currentLocation).get(destination);

            Set<String> otherLocations = new TreeSet(availableLocations);
            otherLocations.remove(destination);

            List<Integer> childDistances = findAllDistances(distanceLookup, destination, otherLocations);

            if (childDistances.size() == 0)
            {
                allDistances.add(distanceTravelled);
                break;
            }

            for (int i = 0; i < childDistances.size(); i++)
            {
                childDistances.set(i, childDistances.get(i) + distanceTravelled);
            }

            allDistances.addAll(childDistances);
        }

        return allDistances;
    }
}
