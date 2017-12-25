package day02;

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
}
