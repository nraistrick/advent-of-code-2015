package day22.Effects;

/**
 * Represents an cast effect that lasts multiple turns
 */
public abstract class Effect implements Cloneable
{
    protected int manaCost;
    protected int remainingTicks;

    protected Effect(int manaCost, int remainingTicks)
    {
        this.manaCost = manaCost;
        this.remainingTicks = remainingTicks;
    }

    public int getManaCost()
    {
        return manaCost;
    }

    public int getRemainingTicks()
    {
        return remainingTicks;
    }

    public Effect clone()
    {
        try
        {
            return (Effect) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
}
