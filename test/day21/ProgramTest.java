package day21;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgramTest
{
    @Test
    void checkYouWinBossBattle() throws IOException
    {
        assertEquals(false, Program.checkIfYouWinBossBattle(1, 1));
        assertEquals(false, Program.checkIfYouWinBossBattle(3, 2));
        assertEquals(true, Program.checkIfYouWinBossBattle(20, 10));
        assertEquals(true, Program.checkIfYouWinBossBattle(9, 2));
    }

    @Test
    void checkCombineItems()
    {
        CharacterItem weapon = new CharacterItem(74, 8, 0);
        CharacterItem armour = new CharacterItem(53, 0, 3);
        List<CharacterItem> rings = Arrays.asList(new CharacterItem(50, 2, 0),
                                                  new CharacterItem(80, 0,3));

        List<CharacterItem> equipped = new ArrayList();
        equipped.add(weapon);
        equipped.add(armour);
        equipped.addAll(rings);

        CharacterItem combined = Program.combineItems(equipped);
        assertEquals(10,  combined.get_damage());
        assertEquals(6,   combined.get_armour());
        assertEquals(257, combined.get_cost());
    }
}