package day22.Spells;

/**
 * An ability that immediately deals damage
 */
public abstract class Spell
{
    protected int manaCost;
    protected int damage;
    protected int healthGain;

    protected Spell(int manaCost, int damage)
    {
        this.manaCost = manaCost;
        this.damage = damage;
    }

    public int getManaCost()
    {
        return manaCost;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getHealthGain()
    {
        return healthGain;
    }
}
