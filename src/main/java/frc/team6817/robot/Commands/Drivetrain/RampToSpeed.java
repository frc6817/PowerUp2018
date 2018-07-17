package frc.team6817.robot.Commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team6817.robot.Clock;
import frc.team6817.robot.RobotMap;

import static frc.team6817.robot.Robot.drivetrain;
import static frc.team6817.robot.RobotMap.backLeftController;
import static frc.team6817.robot.RobotMap.backRightController;


public class RampToSpeed extends Command
{
    private double _target;
    private long _rampTime;

    boolean _finished = false;
//ya yeet what up my dude I hope everything is going well


    public RampToSpeed(double maxValue , long rampTime)
    {
        super();

        requires(drivetrain);

        _target = maxValue;
        _rampTime = rampTime;
    }


    @Override
    public void execute()
    {
        _finished = false;

        Clock clock = new Clock();
        long startTime = System.currentTimeMillis();
        double motorPower = 0;

        while(System.currentTimeMillis() - startTime < _rampTime)
        {
            if(clock.tick(10))
            {
                motorPower += _target * 10 / _rampTime;

                RobotMap.frontLeftController.set(motorPower);
                backLeftController.set(motorPower);
                RobotMap.frontRightController.set(-motorPower);
                backRightController.set(-motorPower);
            }
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
