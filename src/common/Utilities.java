package common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
}
