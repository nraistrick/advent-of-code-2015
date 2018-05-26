package common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest
{
    private static final String testResource = "common/test.txt";

    @Test
    void getFileContents() throws IOException
    {
        String contents = Utilities.getFileContents(testResource);
        assertEquals("hello world\nhello world", contents);
    }

    @Test
    void getFileLines() throws IOException
    {
        List<String> contents = Utilities.getFileLines(testResource);
        assertEquals(Arrays.asList("hello world", "hello world"), contents);
    }

    @Test
    void getMD5Hash() throws NoSuchAlgorithmException
    {
        assertEquals("5d41402abc4b2a76b9719d911017c592", Utilities.getMD5Hash("hello"));
    }

    @Test
    void getHash() throws NoSuchAlgorithmException
    {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        assertEquals("5d41402abc4b2a76b9719d911017c592", Utilities.getHash("hello", messageDigest));

        messageDigest = MessageDigest.getInstance("SHA1");
        assertEquals("aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d", Utilities.getHash("hello", messageDigest));
    }

    @Test
    void convertByteToHex()
    {
        assertEquals("68656c6c6f", Utilities.convertByteToHex("hello".getBytes()));
    }

    @Test
    void nthIndexOf()
    {
        assertEquals(0,  Utilities.nthIndexOf("abc abc abc", "abc", 1));
        assertEquals(4,  Utilities.nthIndexOf("abc abc abc", "abc", 2));
        assertEquals(3,  Utilities.nthIndexOf("abcabcabc", "abc", 2));
        assertEquals(6,  Utilities.nthIndexOf("abcabcabc", "abc", 3));
        assertEquals(8,  Utilities.nthIndexOf("abc abc abc", "abc", 3));
        assertEquals(13, Utilities.nthIndexOf("abc abc defasabc", "abc", 3));
        assertEquals(-1, Utilities.nthIndexOf("abc abc defasabc", "abc", 4));
    }

    @Test
    void findSumCombinations()
    {
        List<List<Integer>> combinations = Utilities.findSumCombinations(1, 2);
        assertEquals("[[0, 1], [1, 0]]", combinations.toString());

        combinations = Utilities.findSumCombinations(1, 3);
        assertEquals("[[0, 0, 1], [0, 1, 0], [1, 0, 0]]", combinations.toString());

        combinations = Utilities.findSumCombinations(2, 3);
        assertEquals("[[0, 0, 2], [0, 1, 1], [0, 2, 0], " +
                     "[1, 0, 1], [1, 1, 0], [2, 0, 0]]",
                     combinations.toString());

        combinations = Utilities.findSumCombinations(3, 3);
        assertEquals("[[0, 0, 3], [0, 1, 2], [0, 2, 1], " +
                     "[0, 3, 0], [1, 0, 2], [1, 1, 1], " +
                     "[1, 2, 0], [2, 0, 1], [2, 1, 0], [3, 0, 0]]",
                     combinations.toString());
    }

    @Test
    void capitaliseFirstLetter()
    {
        assertEquals("Hello", Utilities.capitaliseFirstLetter("hello"));
        assertEquals("Bob vance", Utilities.capitaliseFirstLetter("bob vance"));
    }

    @Test
    void findSizeOfSmallest()
    {
        List<List<Integer>> input = new ArrayList();
        input.add(Arrays.asList(1, 2));
        input.add(Arrays.asList(1, 2, 3));
        input.add(Arrays.asList(1, 2, 3, 4));

        assertEquals(2, Utilities.findSizeOfSmallest(input));

        List<List<String>> otherInput = new ArrayList();
        otherInput.add(Arrays.asList("a", "b", "c", "d"));
        otherInput.add(Arrays.asList("a", "b", "c"));

        assertEquals(3, Utilities.findSizeOfSmallest(otherInput));
    }

    @Test
    void getPermutations()
    {
        List<Integer> numbers = new ArrayList(Arrays.asList(1, 2, 3));

        assertEquals("[[1], [2], [3]]",
                Utilities.getPermutations(numbers, 1).toString());

        assertEquals("[[1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]]",
                Utilities.getPermutations(numbers, 2).toString());

        assertEquals("[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]",
                Utilities.getPermutations(numbers, 3).toString());
    }
}