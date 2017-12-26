package day04;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void getHashEnumerationWithLeadingZeroes() throws NoSuchAlgorithmException
    {
        assertEquals(609043, Program.getHashEnumerationWithLeadingZeroes("abcdef"));
        assertEquals(1048970, Program.getHashEnumerationWithLeadingZeroes("pqrstuv"));
    }

}