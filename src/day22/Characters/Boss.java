package day22.Characters;

import day22.Effects.Effect;
import day22.Effects.NegativeEffect;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Character
{
    private int damage;
    private List<NegativeEffect> effectsApplied;

    public Boss(int hitpoints, int damage)
    {
        this.hitpoints = hitpoints;
        this.damage = damage;
        effectsApplied = new ArrayList();
    }

    /**
     * Creates an exact copy of a boss character
     */
    public Boss(Boss other)
    {
        this(other.hitpoints, other.damage);

        for (Effect e : other.effectsApplied)
        {
            effectsApplied.add((NegativeEffect) e.clone());
        }
    }

    public int getDamage()
    {
        return damage;
    }

    public List<NegativeEffect> getEffects()
    {
        return effectsApplied;
    }

    public void addEffect(NegativeEffect effect)
    {
        effectsApplied.add(effect);
    }

    public void executeEffects()
    {
        List<NegativeEffect> effectsToRemove = new ArrayList();

        for (NegativeEffect e : effectsApplied)
        {
            e.execute(this);

            if (e.getRemainingTicks() <= 0)
            {
                effectsToRemove.add(e);
            }
        }

        effectsApplied.removeAll(effectsToRemove);
    }
}
