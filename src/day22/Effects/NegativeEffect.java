package day22.Effects;

import day22.Characters.Boss;

/**
 * Causes damage over time
 */
public abstract class NegativeEffect extends Effect
{
    protected int damage;

    protected NegativeEffect(int manaCost, int remainingTicks, int damage)
    {
        super(manaCost, remainingTicks);
        this.damage = damage;
    }

    public abstract void execute(Boss boss);
}
