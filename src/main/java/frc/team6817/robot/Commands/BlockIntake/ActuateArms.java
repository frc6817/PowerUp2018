package frc.team6817.robot.Commands.BlockIntake;


import edu.wpi.first.wpilibj.command.Command;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.RobotMap.leftIntakePiston;
import static frc.team6817.robot.RobotMap.rightIntakeController;
import static frc.team6817.robot.RobotMap.rightIntakePiston;

public class ActuateArms extends Command
{
    private boolean _actuateOutward;


    public ActuateArms(boolean OUTWARD)
    {
        super();

        _actuateOutward = OUTWARD;

        requires(blockIntake);
    }


    @Override
    public void execute()
    {
        leftIntakePiston.set(_actuateOutward);
        rightIntakePiston.set(_actuateOutward);
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
        return leftIntakePiston.get() == _actuateOutward && rightIntakePiston.get() == _actuateOutward;
    }
}
