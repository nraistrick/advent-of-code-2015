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
        int hashEnumeration = getHashEnumerationWithLeadingZeroes("yzbqklnj");
        System.out.println(String.format("The first hash with five leading zeroes is: %d", hashEnumeration));
    }

    public static int getHashEnumerationWithLeadingZeroes(String secretKey) throws NoSuchAlgorithmException
    {
        for (int i = 0; i < 5000000; i++)
        {
            String hash = Utilities.getMD5Hash(String.format("%s%d", secretKey, i));
            if (hash.startsWith("00000")) return i;
        }

        throw new IllegalArgumentException("A hash with five leading zeroes does not exist for the provided key");
    }
}
