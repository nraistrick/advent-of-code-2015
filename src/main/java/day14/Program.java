package day14;

import common.Utilities;

import java.io.IOException;
import java.util.*;

/**
 * Calculates the distance travelled and maximum points accumulated by the
 * winner in a race between Santa's reindeer
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day14/input.txt");
        List<Reindeer> reindeer = createReindeer(inputData);

        int maxDistance = getMaxDistanceTravelled(reindeer, 2503);

        System.out.println("The distance travelled by the winning reindeer was: " + maxDistance);

        reindeer = createReindeer(inputData);
        int maxPoints = getMaximumPoints(reindeer, 2503);

        System.out.println("The maximum points for the winning reindeer was: " + maxPoints);
    }

    public static int getMaximumPoints(List<Reindeer> reindeer, int raceDuration)
    {
        Map<String, Integer> points = new HashMap();
        for (Reindeer r : reindeer) points.put(r.Name, 0);

        for (int i = 0; i < raceDuration; i++)
        {
            moveReindeerForward(reindeer);

            int furtherDistance = reindeer.get(reindeer.size() - 1).DistanceTravelled;
            List<Reindeer> firstPlaceReindeer = new ArrayList(reindeer);

            for (int j = firstPlaceReindeer.size() - 1; j >= 0; j--)
            {
                if (firstPlaceReindeer.get(j).DistanceTravelled > furtherDistance)
                {
                    for (int k = firstPlaceReindeer.size() - 1; k > j; k--)
                    {
                        firstPlaceReindeer.remove(k);
                    }

                    furtherDistance = firstPlaceReindeer.get(j).DistanceTravelled;
                }
                else if (firstPlaceReindeer.get(j).DistanceTravelled < furtherDistance)
                {
                    firstPlaceReindeer.remove(j);
                }
            }

            for (Reindeer r: firstPlaceReindeer)
            {
                points.put(r.Name, points.get(r.Name) + 1);
            }
        }

        return Collections.max(points.values());
    }

    public static int getMaxDistanceTravelled(List<Reindeer> reindeer, int raceDuration)
    {
        for (int i = 0; i < raceDuration; i++) moveReindeerForward(reindeer);

        List<Integer> finalDistances = new ArrayList();
        for (Reindeer r : reindeer) finalDistances.add(r.DistanceTravelled);

        return Collections.max(finalDistances);
    }

    public static List<Reindeer> createReindeer(List<String> inputData)
    {
        List<Reindeer> reindeer = new ArrayList();

        for (String line : inputData)
        {
            String[] split = line.split(" ");

            String name  = split[0];
            int speed    = Integer.parseInt(split[3]);
            int flyTime  = Integer.parseInt(split[6]);
            int restTime = Integer.parseInt(split[13]);

            reindeer.add(new Reindeer(speed, flyTime, restTime, name));
        }

        return reindeer;
    }

    public static void moveReindeerForward(List<Reindeer> reindeer)
    {
        for (Reindeer r : reindeer) r.moveForward();
    }
}
