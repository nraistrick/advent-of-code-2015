package day22.Effects;

import day22.Characters.Player;

public abstract class PositiveEffect extends Effect
{
    protected PositiveEffect(int manaCost, int remainingTicks)
    {
        super(manaCost, remainingTicks);
    }

    public abstract void execute(Player player);
}
