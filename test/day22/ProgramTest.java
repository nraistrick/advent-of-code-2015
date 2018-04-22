package day22;

import day22.Characters.Boss;
import day22.Characters.Player;
import day22.Effects.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProgramTest
{
    @Test
    void checkRechargeEffectAppliedCorrectly()
    {
        Player player = new Player(1000, 0);
        player.addEffect(new Recharge());

        assertEquals(0, player.getMana());

        for (int ticks = 1; ticks <= 5; ticks++)
        {
            player.executeEffects();
            assertEquals(101 * ticks, player.getMana());
        }

        player.executeEffects();
        assertEquals(505, player.getMana());
    }

    @Test
    void checkShieldEffectAppliedCorrectly()
    {
        Player player = new Player(1000, 0);
        player.addEffect(new Shield());

        assertEquals(0, player.getArmour());

        for (int ticks = 1; ticks <= 5; ticks++)
        {
            player.executeEffects();
            assertEquals(7, player.getArmour());
        }

        player.executeEffects();
        assertEquals(0, player.getArmour());
    }

    @Test
    void checkPoisonEffectAppliedCorrectly()
    {
        final int initialHp = 1000;

        Boss boss = new Boss(initialHp, 0);
        boss.addEffect(new Poison());

        assertEquals(initialHp, boss.getHitpoints());

        for (int ticks = 1; ticks <= 6; ticks++)
        {
            boss.executeEffects();
            assertEquals(initialHp - (3 * ticks), boss.getHitpoints());
        }

        boss.executeEffects();
        assertEquals(initialHp - 18, boss.getHitpoints());
    }

    @Test
    void checkPlayerObjectCopyWorksCorrectly()
    {
        Player player = new Player(100, 100);
        PositiveEffect shield = new Shield();

        player.addEffect(shield);

        Player playerClone = new Player(player);

        PositiveEffect effect = player.getEffects().get(0);
        PositiveEffect clonedEffect = playerClone.getEffects().get(0);

        assertNotEquals(System.identityHashCode(effect),
                        System.identityHashCode(clonedEffect));

        assertEquals(effect.getManaCost(), clonedEffect.getManaCost());
        assertEquals(effect.getRemainingTicks(), clonedEffect.getRemainingTicks());
    }

    @Test
    void checkBossObjectCopyWorksCorrectly()
    {
        Boss boss = new Boss(100, 100);
        NegativeEffect shield = new Poison();

        boss.addEffect(shield);

        Boss bossClone = new Boss(boss);

        NegativeEffect effect = boss.getEffects().get(0);
        NegativeEffect clonedEffect = bossClone.getEffects().get(0);

        assertNotEquals(System.identityHashCode(effect),
                        System.identityHashCode(clonedEffect));

        assertEquals(effect.getManaCost(), clonedEffect.getManaCost());
        assertEquals(effect.getRemainingTicks(), clonedEffect.getRemainingTicks());
    }

    @Test
    void checkMinimumManaCalculatedCorrectly() throws GameOver
    {
        int manaSpent = Program.calculateMinimumManaSpent(
                new State(new Player(10, 250), new Boss(13, 8), false), false);
        assertEquals(226, manaSpent);

        manaSpent = Program.calculateMinimumManaSpent(
                new State(new Player(10, 250), new Boss(14, 8), false), false);
        assertEquals(641, manaSpent);
    }

    @Test
    void checkMinimumManaCalculatedCorrectlyInHardMode() throws GameOver
    {
        int manaSpent = Program.calculateMinimumManaSpent(
                new State(new Player(14, 250), new Boss(13, 8), false), true);
        assertEquals(226, manaSpent);

        manaSpent = Program.calculateMinimumManaSpent(
                new State(new Player(15, 250), new Boss(14, 8), false), true);
        assertEquals(588, manaSpent);
    }
}
