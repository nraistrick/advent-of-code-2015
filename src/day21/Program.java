package day21;

import common.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Calculate the winner of a battle in an RPG-simulator game based
 * off the amount of gold spent on various items
 */
public class Program
{
    private static final int BOSS_DAMAGE = 8;
    private static final int BOSS_ARMOUR = 2;
    private static final int BOSS_HP = 109;
    private static final int YOUR_HP = 100;

    private static final List<CharacterItem> weapons = Arrays.asList(
            new CharacterItem(8, 4, 0),
            new CharacterItem(10, 5, 0),
            new CharacterItem(25, 6, 0),
            new CharacterItem(40, 7, 0),
            new CharacterItem(74, 8, 0));

    private static final List<CharacterItem> armour = Arrays.asList(

            // A dummy option to allow for no armour selection
            new CharacterItem(0, 0, 0),

            new CharacterItem(13, 0, 1),
            new CharacterItem(31, 0, 2),
            new CharacterItem(53, 0, 3),
            new CharacterItem(75, 0, 4),
            new CharacterItem(102, 0, 5));

    private static final List<CharacterItem> rings = Arrays.asList(

            // Two dummy options to allow for one or no ring selection
            new CharacterItem(0, 0, 0),
            new CharacterItem(0, 0, 0),

            new CharacterItem(25, 1, 0),
            new CharacterItem(50, 2, 0),
            new CharacterItem(100, 3, 0),
            new CharacterItem(20, 0, 1),
            new CharacterItem(40, 0, 2),
            new CharacterItem(80, 0,3));

    public static void main(String[] args)
    {
        int minimumCost = calculateCheapestWayToWin();
        System.out.println("The minimum cost required to win is: " + minimumCost);
    }

    public static int calculateCheapestWayToWin()
    {
        int minimumCost = -1;
        List<List<CharacterItem>> ringCombinations = Utilities.getPermutations(rings, 2);

        for(CharacterItem weapon : weapons)
        {
            for(CharacterItem armour : armour)
            {
                for(List<CharacterItem> ringCombination : ringCombinations)
                {
                    List<CharacterItem> equipped = new ArrayList();
                    equipped.add(weapon);
                    equipped.add(armour);
                    equipped.addAll(ringCombination);

                    CharacterItem combined = combineItems(equipped);

                    if(checkIfYouWinBossBattle(combined.get_damage(), combined.get_armour())
                            && (minimumCost == -1 || combined.get_cost() < minimumCost))
                    {
                        minimumCost = combined.get_cost();
                    }
                }
            }
        }

        return minimumCost;
    }

    public static CharacterItem combineItems(List<CharacterItem> equippedItems)
    {
        CharacterItem combined = new CharacterItem(0, 0, 0);

        for (CharacterItem item : equippedItems)
        {
            combined.set_cost(combined.get_cost() + item.get_cost());
            combined.set_armour(combined.get_armour() + item.get_armour());
            combined.set_damage(combined.get_damage() + item.get_damage());
        }

        return combined;
    }

    public static boolean checkIfYouWinBossBattle(int yourDamage, int yourArmour)
    {
        int bossHp = BOSS_HP;
        int yourHp = YOUR_HP;

        while(bossHp > 0 && yourHp > 0)
        {
            bossHp = calculateHpAfterAttack(bossHp, yourDamage, BOSS_ARMOUR);
            yourHp = calculateHpAfterAttack(yourHp, BOSS_DAMAGE, yourArmour);
        }

        if (bossHp <= 0) return true;
        else             return false;
    }

    private static int calculateHpAfterAttack(int currentHp, int damageScore, int armourScore)
    {
        int damage = Math.max(damageScore - armourScore, 1);
        return currentHp - damage;
    }
}
