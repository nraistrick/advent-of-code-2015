package day22;

import day22.Characters.Boss;
import day22.Characters.Player;
import day22.Effects.*;
import day22.Spells.Drain;
import day22.Spells.MagicMissile;
import day22.Spells.Spell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A program to simulate an RPG battle between two characters
 * and find the minimum mana cost required to win
 */
public class Program
{
    public static void main(String[] args) throws GameOver
    {
        Player player = new Player(50, 500);
        Boss boss = new Boss(58, 9);

        int manaSpent = executeMove(player, boss, false);

        System.out.println("The smallest amount of mana required to win is: " + manaSpent);
    }

    public static List<Effect> getEffects()
    {
        return Arrays.asList(new Poison(), new Recharge(), new Shield());
    }

    public static List<Spell> getSpells()
    {
        return Arrays.asList(new Drain(), new MagicMissile());
    }

    public static int executeMove(Player player, Boss boss, boolean bossesTurn) throws GameOver
    {
        List<Integer> manaSpentOptions = new ArrayList();

        if (boss.getHitpoints() <= 0) return player.getTotalManaUsed();
        if (player.getHitpoints() <= 0) throw new GameOver("The player has died");

        // Apply existing effects to boss/player
        player.executeEffects();
        boss.executeEffects();

        if (boss.getHitpoints() <= 0) return player.getTotalManaUsed();
        if (player.getHitpoints() <= 0) throw new GameOver("The player has died");

        if (bossesTurn)
        {
            // Boss attacks
            int bossDamage = Math.max(1, boss.getDamage() - player.getArmour());
            player.setHitpoints(player.getHitpoints() - bossDamage);
            manaSpentOptions.add(executeMove(player, boss, false));
        }
        else
        {
            // Execute effects
            for (Effect e : getEffects())
            {
                boolean effectAlreadyApplied = false;

                for (PositiveEffect pe : player.getEffects())
                {
                    if (pe.getClass().equals(e.getClass())) effectAlreadyApplied = true;
                }

                for (NegativeEffect ne : boss.getEffects())
                {
                    if (ne.getClass().equals(e.getClass())) effectAlreadyApplied = true;
                }

                if (player.getMana() >= e.getManaCost() && effectAlreadyApplied == false)
                {
                    Boss bossCopy = new Boss(boss);
                    Player playerCopy = new Player(player);

                    // Player attacks
                    playerCopy.spendMana(e.getManaCost());
                    if (e instanceof NegativeEffect) bossCopy.addEffect((NegativeEffect) e);
                    else playerCopy.addEffect((PositiveEffect) e);

                    try
                    {
                        manaSpentOptions.add(executeMove(playerCopy, bossCopy, true));
                    }
                    catch (GameOver gameOver) { }
                }
            }

            // Execute spells
            for (Spell s : getSpells())
            {
                if (player.getMana() >= s.getManaCost())
                {
                    Boss bossCopy = new Boss(boss);
                    Player playerCopy = new Player(player);

                    // Player attacks
                    playerCopy.spendMana(s.getManaCost());
                    bossCopy.setHitpoints(boss.getHitpoints() - s.getDamage());
                    playerCopy.setHitpoints(playerCopy.getHitpoints() + s.getHealthGain());

                    try
                    {
                        manaSpentOptions.add(executeMove(playerCopy, bossCopy, true));
                    }
                    catch (GameOver gameOver) { }
                }
            }

            // Check we successfully executed an attack on the boss
            if (manaSpentOptions.isEmpty()) throw new GameOver("The player does not have enough mana left " +
                                                               "to execute another move");
        }

        // Return minimum cost sequence
        int minimumIndex = manaSpentOptions.indexOf(Collections.min(manaSpentOptions));
        return manaSpentOptions.get(minimumIndex);
    }
}
