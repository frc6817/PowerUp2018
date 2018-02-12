package frc.team6817.robot.Commands.Drivetrain;


import edu.wpi.first.wpilibj.command.Command;

import static frc.team6817.robot.Robot.drivetrain;


public class DriveForTime extends Command
{
    private double _leftPower;
    private double _rightPower;
    private long _time;

    private boolean _finished = false;


    /**
     * Creates a Drive For Time command, requires the drivetrain
     *
     * Invokes superconstructor.
     *
     * @param LEFT_POWER Power to set to the left side
     * @param RIGHT_POWER Power to set to the right side
     * @param TIME Time to drive to in milliseconds
     */
    public DriveForTime(final double LEFT_POWER , final double RIGHT_POWER , final long TIME)
    {
        super();

        requires(drivetrain);
        _leftPower = LEFT_POWER;
        _rightPower = RIGHT_POWER;
        _time = TIME;
    }


    @Override
    public void execute()
    {
        long startTime = System.currentTimeMillis();

        //noinspection StatementWithEmptyBody
        while(System.currentTimeMillis() - startTime < _time)
        {
            drivetrain.tankDrive(-_leftPower , -_rightPower , false);
        }

        _finished = true;
    }


    @Override
    public void interrupted()
    {
        drivetrain.stop();
    }


    @Override
    public void end()
    {
        drivetrain.stop();
    }


    @Override
    protected boolean isFinished()
    {
        return _finished;
    }
}
