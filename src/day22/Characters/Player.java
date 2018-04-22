package day22.Characters;

import day22.Effects.Effect;
import day22.Effects.PositiveEffect;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character
{
    private int armour;
    private int mana;
    private int totalManaUsed;
    private List<PositiveEffect> effectsApplied;

    public Player(int hitpoints, int mana)
    {
        this.hitpoints = hitpoints;
        this.mana = mana;
        this.totalManaUsed = 0;
        effectsApplied = new ArrayList();
    }

    /**
     * Creates an exact copy of a player character
     */
    public Player(Player other)
    {
        armour = other.armour;
        hitpoints = other.hitpoints;
        mana = other.mana;
        totalManaUsed = other.totalManaUsed;

        effectsApplied = new ArrayList();

        for (Effect e : other.effectsApplied)
        {
            effectsApplied.add((PositiveEffect)e.clone());
        }
    }

    public int getArmour()
    {
        return armour;
    }

    public void setArmour(int armour)
    {
        this.armour = armour;
    }

    public int getMana()
    {
        return mana;
    }

    public void setMana(int mana)
    {
        this.mana = mana;
    }

    public int getTotalManaUsed()
    {
        return totalManaUsed;
    }

    public void spendMana(int manaCost)
    {
        mana -= manaCost;
        totalManaUsed += manaCost;
    }

    public List<PositiveEffect> getEffects()
    {
        return effectsApplied;
    }

    public void addEffect(PositiveEffect effect)
    {
        effectsApplied.add(effect);
    }

    public void executeEffects()
    {
        List<PositiveEffect> effectsToRemove = new ArrayList();

        for (PositiveEffect e : effectsApplied)
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
