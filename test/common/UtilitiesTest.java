package common;

import org.junit.jupiter.api.Test;

import java.io.IOException;
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

}