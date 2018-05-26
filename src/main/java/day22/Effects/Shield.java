package day22.Effects;

import day22.Characters.Player;

/**
 * Provides armour over time
 */
public class Shield extends PositiveEffect
{
    private static final int maxTicks = 6;

    private int armourGain;

    public Shield()
    {
        super(113, maxTicks);
        armourGain = 7;
    }

    public void execute(Player player)
    {
        if(remainingTicks == maxTicks)
        {
            player.setArmour(player.getArmour() + armourGain);
        }

        remainingTicks--;

        if (remainingTicks == 0)
        {
            player.setArmour(player.getArmour() - armourGain);
        }
    }
}
