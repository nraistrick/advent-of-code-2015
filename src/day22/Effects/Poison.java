package day22.Effects;

import day22.Characters.Boss;

public class Poison extends NegativeEffect
{
    public Poison()
    {
        super(173, 6, 3);
    }

    public void execute(Boss boss)
    {
        boss.setHitpoints(boss.getHitpoints() - damage);
        remainingTicks--;
    }
}
