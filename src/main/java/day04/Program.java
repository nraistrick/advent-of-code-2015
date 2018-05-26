package day04;

import common.Utilities;

import java.security.NoSuchAlgorithmException;

/**
 * Help mine some AdventCoins (similar to Bitcoins) by finding hash
 * values that begin with a sequence of zeroes for a given value
 */
public class Program
{
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        int hashEnumeration = getHashEnumeration("yzbqklnj", "00000");
        System.out.println(String.format("The first hash with five leading zeroes is: %d", hashEnumeration));

        hashEnumeration = getHashEnumeration("yzbqklnj", "000000");
        System.out.println(String.format("The first hash with six leading zeroes is: %d", hashEnumeration));
    }

    public static int getHashEnumeration(String secretKey, String beginning) throws NoSuchAlgorithmException
    {
        for (int i = 0; i < 10000000; i++)
        {
            String hash = Utilities.getMD5Hash(String.format("%s%d", secretKey, i));
            if (hash.startsWith(beginning)) return i;
        }

        throw new IllegalArgumentException(String.format("A hash beginning with '%s' does not exist " +
                                                         "for the provided key", beginning));
    }
}
