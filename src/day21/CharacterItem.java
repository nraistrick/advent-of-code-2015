package day21;

public class CharacterItem
{
    private int _cost;
    private int _damage;
    private int _armour;

    public CharacterItem(int cost, int damage, int armour)
    {
        _cost = cost;
        _damage = damage;
        _armour = armour;
    }

    public int get_cost()
    {
        return this._cost;
    }

    public void set_cost(int _cost)
    {
        this._cost = _cost;
    }

    public int get_damage()
    {
        return this._damage;
    }

    public void set_damage(int _damage)
    {
        this._damage = _damage;
    }

    public int get_armour()
    {
        return this._armour;
    }

    public void set_armour(int _armour)
    {
        this._armour = _armour;
    }
}
