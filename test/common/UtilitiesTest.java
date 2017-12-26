package common;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
}