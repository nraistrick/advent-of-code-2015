package day04;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void getHashEnumerationWithLeadingZeroes() throws NoSuchAlgorithmException
    {
        assertEquals(609043, Program.getHashEnumeration("abcdef", "00000"));
        assertEquals(1048970, Program.getHashEnumeration("pqrstuv", "00000"));
    }

}