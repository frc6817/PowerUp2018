package frc.team6817.robot.Commands.Flipper;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Command;

import static frc.team6817.robot.Robot.flipper;
import static frc.team6817.robot.RobotMap.flipController;


public class FlipForTime extends Command
{
    private final double _THROTTLE = .6;

    private long _activationTime;
    private double _throttle = _THROTTLE;

    private boolean _done = false;


    public FlipForTime(final long TIME , final double THROTTLE)
    {
        _activationTime = TIME;
        _throttle = THROTTLE;

        requires(flipper);
    }


    @Override
    public void execute()
    {
        long startTime = System.currentTimeMillis();

        while(System.currentTimeMillis() - startTime < _activationTime)
        {
            flipController.set(ControlMode.PercentOutput , _throttle);
        }

        _done = true;
    }


    @Override
    public void interrupted()
    {
        flipController.set(ControlMode.PercentOutput , 0);
    }


    @Override
    public void end()
    {
        flipController.set(ControlMode.PercentOutput , 0);
    }


    @Override
    protected boolean isFinished()
    {
        return _done;
    }
}
