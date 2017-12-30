package day19;

import common.Utilities;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Calculate information about medicine molecules you can use to help
 * Rudolph feel better
 */
public class Program
{
    public static void main(String[] args) throws IOException
    {
        String molecule = "CRnSiRnCaPTiMgYCaPTiRnFArSiThFArCaSiThSiThPBCaCaSiRnSiRnTiTiMgArPBCaPMgY" +
                          "PTiRnFArFArCaSiRnBPMgArPRnCaPTiRnFArCaSiThCaCaFArPBCaCaPTiTiRnFArCaSiRnS" +
                          "iAlYSiThRnFArArCaSiRnBFArCaCaSiRnSiThCaCaCaFYCaPTiBCaSiThCaSiThPMgArSiRn" +
                          "CaPBFYCaCaFArCaCaCaCaSiThCaSiRnPRnFArPBSiThPRnFArSiRnMgArCaFYFArCaSiRnSi" +
                          "AlArTiTiTiTiTiTiTiRnPMgArPTiTiTiBSiRnSiAlArTiTiRnPMgArCaFYBPBPTiRnSiRnMg" +
                          "ArSiThCaFArCaSiThFArPRnFArCaSiRnTiBSiThSiRnSiAlYCaFArPRnFArSiThCaFArCaCa" +
                          "SiThCaCaCaSiRnPRnCaFArFYPMgArCaPBCaPBSiRnFYPBCaFArCaSiAl";

        List<String> inputData = Utilities.getFileLines("day19/input.txt");
        List<Map.Entry<String, String>> replacements = getReplacements(inputData);
        List<String> distinctSubstitutions = getDistinctSubstitutes(molecule, replacements);

        System.out.println("The number of distinct molecules that can be created are: " + distinctSubstitutions.size());
    }

    public static List<Map.Entry<String, String>> getReplacements(List<String> inputData)
    {
        List<Map.Entry<String, String>> replacements = new ArrayList();

        for (String line : inputData)
        {
            String[] split = line.split(" ");
            Map.Entry<String, String> newPair = new AbstractMap.SimpleEntry(split[0], split[2]);
            replacements.add(newPair);
        }

        return replacements;
    }

    public static List<String> getDistinctSubstitutes(String molecule, List<Map.Entry<String, String>> replacements)
    {
        List<String> allSubstitutes = new ArrayList();
        for ( Map.Entry<String, String> pair : replacements)
        {
            allSubstitutes.addAll(getAllSubstitutions(molecule, pair.getKey(), pair.getValue()));
        }

        return allSubstitutes.stream().distinct().collect(Collectors.toList());
    }

    public static List<String> getAllSubstitutions(String molecule, String original, String replacement)
    {
        List<String> generatedMolecules = new ArrayList();

        for (int i = 0; i < molecule.length() - (original.length() - 1); i++)
        {
            String substring = molecule.substring(i, i + original.length());

            if (substring.equals(original))
            {
                String generated = molecule.substring(0, i) +
                                   replacement +
                                   molecule.substring(i + original.length(), molecule.length());

                generatedMolecules.add(generated);
            }
        }

        return generatedMolecules;
    }
}
