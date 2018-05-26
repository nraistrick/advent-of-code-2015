package day15;

public class Ingredient
{
    private int _capacity;
    private int _durability;
    private int _flavour;
    private int _texture;
    private int _calories;

    private int _quantity;

    public Ingredient(int capacity, int durability, int flavour, int texture, int calories)
    {
        _capacity   = capacity;
        _durability = durability;
        _flavour    = flavour;
        _texture    = texture;
        _calories   = calories;

        _quantity = 0;
    }

    public int getTotalCapacity()   { return _capacity   * _quantity; }
    public int getTotalDurability() { return _durability * _quantity; }
    public int getTotalFlavour()    { return _flavour    * _quantity; }
    public int getTotalTexture()    { return _texture    * _quantity; }
    public int getTotalCalories()   { return _calories   * _quantity; }

    public void setQuantity(int quantity)
    {
        _quantity = quantity;
    }
}
