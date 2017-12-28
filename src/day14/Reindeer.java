package day14;

/**
 * Models the movement of one of Santa's reindeer in a race
 */
public class Reindeer
{
    public int TopSpeed;
    public int FlyTime;
    public int RestTime;

    public int DistanceTravelled;

    private int _remainingFlyTime;
    private int _remainingRestTime;

    public Reindeer(int topSpeed, int flyTime, int restTime)
    {
        TopSpeed = topSpeed;
        FlyTime = flyTime;
        RestTime = restTime;

        DistanceTravelled = 0;

        _remainingFlyTime = FlyTime;
        _remainingRestTime = 0;
    }

    /**
     * Moves the reindeer forward one second in time
     */
    public void moveForward()
    {
        if (_remainingFlyTime > 0)
        {
            DistanceTravelled += TopSpeed;
            _remainingFlyTime--;

            if (_remainingFlyTime == 0) _remainingRestTime = RestTime;
        }
        else if (_remainingRestTime > 0)
        {
            _remainingRestTime--;
            if (_remainingRestTime == 0) _remainingFlyTime = FlyTime;
        }
    }
}
