package day14;

import common.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Calculates the distance travelled by the winner in a race between
 * Santa's reindeer
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day14/input.txt");
        List<Reindeer> reindeer = createReindeer(inputData);

        int maxDistance = getMaxDistanceTravelled(reindeer, 2503);

        System.out.println("The distance travelled by the winning reindeer was: " + maxDistance);
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

            int speed    = Integer.parseInt(split[3]);
            int flyTime  = Integer.parseInt(split[6]);
            int restTime = Integer.parseInt(split[13]);

            reindeer.add(new Reindeer(speed, flyTime, restTime));
        }

        return reindeer;
    }

    public static void moveReindeerForward(List<Reindeer> reindeer)
    {
        for (Reindeer r : reindeer) r.moveForward();
    }
}
