package day22;

import day22.Characters.Boss;
import day22.Characters.Player;
import day22.Effects.*;
import day22.Spells.Drain;
import day22.Spells.MagicMissile;
import day22.Spells.Spell;

import java.util.*;

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

        int manaSpent = calculateMinimumManaSpent(new State(player, boss, false));

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

    public static int calculateMinimumManaSpent(State startingState)
    {
        Integer finalManaSpent = null;

        Queue<State> states = new LinkedList();
        states.add(startingState);

        while (!states.isEmpty())
        {
            State state = states.remove();
            Player player = state.player;
            Boss boss = state.boss;
            boolean bossesTurn = state.bossesTurn;

            if (finalManaSpent != null && player.getTotalManaUsed() > finalManaSpent) continue;

            if (boss.getHitpoints() <= 0)
            {
                finalManaSpent = player.getTotalManaUsed();
                continue;
            }

            if (player.getHitpoints() <= 0) continue;

            // Apply existing effects to boss/player
            player.executeEffects();
            boss.executeEffects();

            if (boss.getHitpoints() <= 0)
            {
                finalManaSpent = player.getTotalManaUsed();
                continue;
            }

            if (player.getHitpoints() <= 0) continue;

            if (bossesTurn)
            {
                // Boss attacks
                int bossDamage = Math.max(1, boss.getDamage() - player.getArmour());
                player.setHitpoints(player.getHitpoints() - bossDamage);
                states.add(new State(player, boss, false));
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

                        states.add(new State(playerCopy, bossCopy, true));
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

                        states.add(new State(playerCopy, bossCopy, true));
                    }
                }
            }
        }

        return finalManaSpent;
    }
}
