package common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Utilities
{
    /**
     * Retrieves the entire contents of a file as a single string
     */
    public static String getFileContents(String resourceName) throws IOException
    {
        Path inputPath = getResourcePath(resourceName);
        String contents = new String(Files.readAllBytes(inputPath), StandardCharsets.UTF_8);

        return contents;
    }

    /**
     * Retrieves all lines in a file
     */
    public static List<String> getFileLines(String resourceName) throws IOException
    {
        Path inputPath = getResourcePath(resourceName);
        List<String> fileLines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);

        return fileLines;
    }

    private static Path getResourcePath(String resourceName)
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return Paths.get(classLoader.getResource(resourceName).getPath());
    }


    public static String getMD5Hash(String message) throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        return getHash(message, messageDigest);
    }

    public static String getHash(String message, MessageDigest messageDigest)
    {
        messageDigest.update(message.getBytes());
        byte[] digest = messageDigest.digest();
        return convertByteToHex(digest);
    }

    /**
     * Converts a series of bytes into a hexadecimal string
     */
    public static String convertByteToHex(byte[] byteData) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    /**
     * Finds the index of an nth occurrence of a string
     */
    public static int nthIndexOf(String source, String sought, int n) {
        int index = source.indexOf(sought);
        if (index == -1) return -1;

        for (int i = 1; i < n; i++)
        {
            index = source.indexOf(sought, index + 1);
            if (index == -1) return -1;
        }
        return index;
    }

    public static List<List<Integer>> findSumCombinations(int total, int components)
    {
        return findSumCombinations(total, components, 0);
    }

    private static List<List<Integer>> findSumCombinations(int total, int components, int created)
    {
        if (components < 2)
            throw new IllegalArgumentException("Need to divide the total between at least two numbers");

        if (created == (components - 1))
        {
            List<Integer> combination = new ArrayList<Integer>() {{ add(total); }};
            List<List<Integer>> compoundList = new ArrayList();
            compoundList.add(combination);
            return compoundList;
        }

        List<List<Integer>> combinations = new ArrayList();
        for (int i = 0; i <= total; i++)
        {
            List<List<Integer>> furtherSequences = findSumCombinations(total - i, components, created + 1);
            for (List<Integer> sequence : furtherSequences)
            {
                List<Integer> temp = new ArrayList();
                temp.add(i);
                temp.addAll(sequence);
                combinations.add(temp);
            }
        }

        return combinations;
    }

    public static String capitaliseFirstLetter(String input)
    {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static <T> int findSizeOfSmallest(List<List<T>> lists)
    {
        int smallestLength = 0;
        for (List<T> l : lists)
        {
            if (smallestLength == 0 || l.size() < smallestLength) smallestLength = l.size();
        }

        return smallestLength;
    }
}
