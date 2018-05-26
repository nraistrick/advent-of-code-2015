package day02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Represents a single unwrapped gift
 */
public class Present
{
    int Height, Width, Length;

    public Present(int height, int width, int length)
    {
        Height = height;
        Width  = width;
        Length = length;
    }

    public Present(String dimensions)
    {
        String[] split = dimensions.split("x");

        Height = Integer.parseInt(split[0]);
        Width  = Integer.parseInt(split[1]);
        Length = Integer.parseInt(split[2]);
    }

    public int calculateRequiredPaper()
    {
        int firstSide  = Length * Width;
        int secondSide = Width  * Height;
        int thirdSide  = Height * Length;

        int smallestSide = Math.min(firstSide, Math.min(secondSide, thirdSide));

        return (2 * firstSide) + (2 * secondSide) + (2 * thirdSide) + smallestSide;
    }

    public int calculateRequiredRibbon()
    {
        int ribbonRequired = 0;
        List<Integer> sides = Arrays.asList(Height, Width, Length);
        Collections.sort(sides);
        ribbonRequired += (2 * sides.get(0)) + (2 * sides.get(1));

        ribbonRequired += Height * Width * Length;

        return ribbonRequired;
    }
}
