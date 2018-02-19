package frc.team6817.robot.Commands.BlockIntake;

import edu.wpi.first.wpilibj.command.Command;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.RobotMap.leftIntakeController;
import static frc.team6817.robot.RobotMap.rightIntakeController;


public class PowerIntakeForTime extends Command
{
    private long _time;
    private double _leftPower;
    private double _rightPower;

    private long _startTime;


    /**
     * Creates a Drive For Time command, requires the blockIntake
     *
     * Invokes superconstructor.
     *
     * @param LEFT_POWER  Power to set to the left side
     * @param RIGHT_POWER Power to set to the right side
     * @param TIME        Time to collect to in milliseconds
     */
    public PowerIntakeForTime(final double LEFT_POWER, final double RIGHT_POWER, final long TIME)
    {
        super();

        requires(blockIntake);

        _time = TIME;
        _leftPower = LEFT_POWER;
        _rightPower = RIGHT_POWER;
    }


    @Override
    public void execute()
    {
        _startTime = System.currentTimeMillis();

        while(System.currentTimeMillis() - _startTime < _time)
        {
            leftIntakeController.set(_leftPower);
            rightIntakeController.set(_rightPower);
        }
    }


    @Override
    public void interrupted()
    {
        blockIntake.stop();
    }


    @Override
    public void end()
    {
        blockIntake.stop();
    }


    @Override
    protected boolean isFinished()
    {
        return System.currentTimeMillis() - _startTime < _time;
    }
}

