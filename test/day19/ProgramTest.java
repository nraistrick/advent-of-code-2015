package day19;

import common.Utilities;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void getDistinctSubstitutes() throws IOException
    {
        List<String> inputData = Utilities.getFileLines("day19/testinput.txt");
        List<Map.Entry<String, String>> replacements = Program.getReplacements(inputData);
        List<String> distinctSubstitutions = Program.getDistinctSubstitutes("HOH", replacements);
        assertEquals("[HOOH, HOHO, OHOH, HHHH]", distinctSubstitutions.toString());
    }

    @Test
    void getAllSubstitutions()
    {
        List<String> substitutions = Program.getAllSubstitutions("HOH", "H", "HO");
        assertEquals("[HOOH, HOHO]", substitutions.toString());

        substitutions = Program.getAllSubstitutions("HOH", "H", "OH");
        assertEquals("[OHOH, HOOH]", substitutions.toString());

        substitutions = Program.getAllSubstitutions("HOH", "O", "HH");
        assertEquals("[HHHH]", substitutions.toString());
    }

}