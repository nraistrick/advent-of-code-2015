package day10;

/**
 * Calculate the final result for a game of 'look-and-say' played by
 * Santa's elves
 */
public class Program
{
    public static void main(String[] args)
    {
        String currentMove = "3113322113";
        int numberOfTurns = 50;

        for (int i = 0; i < numberOfTurns; i++) currentMove = getNextMove(currentMove);

        System.out.println(String.format("The move length after %d turns is: %s", numberOfTurns, currentMove.length()));
    }

    public static String getNextMove(String lastMove)
    {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        int characterCount = 1;
        char lastCharacter = lastMove.charAt(0);

        while (i < lastMove.length())
        {
            if (lastMove.charAt(i) == lastCharacter)
            {
                characterCount += 1;
            }
            else
            {
                builder.append(characterCount);
                builder.append(lastCharacter);

                lastCharacter = lastMove.charAt(i);
                characterCount = 1;
            }

            i++;
        }

        builder.append(characterCount);
        builder.append(lastCharacter);

        return builder.toString();
    }
}
