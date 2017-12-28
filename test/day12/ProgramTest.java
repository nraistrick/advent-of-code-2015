package day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest
{
    @Test
    void countAllNumbers()
    {
        assertEquals(6, Program.countAllNumbers("[1,2,3]"));
        assertEquals(6, Program.countAllNumbers("{\"a\":2,\"b\":4}"));
        assertEquals(3, Program.countAllNumbers("[[[3]]]"));
        assertEquals(3, Program.countAllNumbers("{\"a\":{\"b\":4},\"c\":-1}"));
        assertEquals(0, Program.countAllNumbers("[-1,{\"a\":1}"));
        assertEquals(0, Program.countAllNumbers("{\"a\":[-1,1]}"));
        assertEquals(0, Program.countAllNumbers("{}"));
        assertEquals(0, Program.countAllNumbers("[]"));
    }

    @Test
    void cleanJson()
    {
        assertEquals("[1,2,3]",    Program.cleanJson("[1,2,3]"));
        assertEquals("[1,,3]",     Program.cleanJson("[1,{c“:“red“,“b“:2},3]"));
        assertEquals("",           Program.cleanJson("{“d“:“red“,“e“:[1,2,3,4],“f“:5}"));
        assertEquals("[1,\"\",5]", Program.cleanJson("[1,\"red\",5]"));

        assertEquals("[1,,2]", Program.cleanJson("[1,{“a”: {“b”:red}, ”c”: {“b”:red},”b”:”red”},2]"));
        assertEquals("[1,,2]", Program.cleanJson("[1,{“a”: {“b”:red}, ”c”: {“b”:red},”b”:”red”},2]"));
        assertEquals("[,2]",   Program.cleanJson("[{“b”:red},2]"));
        assertEquals("[2,]",   Program.cleanJson("[2,{“b”:red}]"));
        assertEquals("[\"\"]", Program.cleanJson("[\"red\"]"));
        assertEquals("[1,,3]", Program.cleanJson("[1,{“a”: {“b”:2}, ”c”:”red“,“b“:2},3]"));
        assertEquals("[1,{”c”:”hello”,”b”:2},3]", Program.cleanJson("[1,{”c”:”hello”,”b”:2},3]"));
    }

    @Test
    void removeContainingObject()
    {
        assertEquals("[1,,3]",                           Program.removeContainingObject("[1,{“a”: {“b”:2}, ”c”:”red”,”b”:2},3]", 23));
        assertEquals("[1,{“a”: , ”c”:”hello”,”b”:2},3]", Program.removeContainingObject("[1,{“a”: {“b”:red}, ”c”:”hello”,”b”:2},3]", 14));
        assertEquals("[1,,2]", Program.removeContainingObject("[1,{“a”: {“b”:red}, ”c”: {“b”:red},”b”:”red”},2]", 38));
    }

    @Test
    void getLeftEnclosingObjectBrace()
    {
        assertEquals(3, Program.getLeftEnclosingObjectBrace("[1,{“a”: {“b”:2}, ”c”:”red”,”b”:2},3]", 23));
        assertEquals(9, Program.getLeftEnclosingObjectBrace("[1,{“a”: {“b”:red}, ”c”:”hello”,”b”:2},3]", 14));
    }

    @Test
    void getRightEnclosingObjectBrace()
    {
        assertEquals(35, Program.getRightEnclosingObjectBrace("[1,{“a”: {“b”:2}, ”c”:{\"a\":1},\"b\":2},3]", 5));
        assertEquals(17, Program.getRightEnclosingObjectBrace("[1,{“a”: {“b”:red}, ”c”:”hello”,”b”:2},3]", 14));
    }
}