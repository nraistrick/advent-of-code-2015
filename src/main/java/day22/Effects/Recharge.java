package day22.Effects;

import day22.Characters.Player;

/**
 * Renews mana over time
 */
public class Recharge extends PositiveEffect
{
    private int manaGain;

    public Recharge()
    {
        super(229, 5);
        manaGain = 101;
    }

    public void execute(Player player)
    {
        player.setMana(player.getMana() + manaGain);
        remainingTicks--;
    }

    public void undo(Player player)
    {
        // Nothing to undo
    }
}
