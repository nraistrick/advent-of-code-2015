package day22;

import day22.Characters.Boss;
import day22.Characters.Player;

/**
 * Represents a snapshot-in-time of a fight between a player and a boss
 */
public class State
{
    public Player player;
    public Boss boss;
    public boolean bossesTurn;

    public State(Player player, Boss boss, boolean bossesTurn)
    {
        this.player = player;
        this.boss = boss;
        this.bossesTurn = bossesTurn;
    }
}
