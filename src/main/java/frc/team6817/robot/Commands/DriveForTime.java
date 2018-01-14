package frc.team6817.robot.Commands;


import edu.wpi.first.wpilibj.command.Command;

import static frc.team6817.robot.Robot.drivetrain;


public class DriveForTime extends Command
{
    private long _time;

    private boolean _finished = false;


    /**
     * Creates a Drive For Time command, requires the drivetrain
     *
     * Invokes superconstructor.
     *
     * @param TIME Time to drive to in milliseconds
     */
    public DriveForTime(final long TIME)
    {
        super();

        requires(drivetrain);
        _time = TIME;
    }


    @Override
    public void execute()
    {
        long startTime = System.currentTimeMillis();

        //noinspection StatementWithEmptyBody
        while(System.currentTimeMillis() - startTime < _time)
        {
            drivetrain.tankDrive(-.5 , -.5 , false);
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
