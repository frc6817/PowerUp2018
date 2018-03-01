package frc.team6817.robot.Commands.BlockIntake;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.RobotMap.dualIntake;


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
        if(_actuateOutward)
        {
            dualIntake.set(DoubleSolenoid.Value.kForward);
        }
        else
        {
            dualIntake.set(DoubleSolenoid.Value.kReverse);
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
        return (dualIntake.get() == DoubleSolenoid.Value.kForward && _actuateOutward)
                || (dualIntake.get() == DoubleSolenoid.Value.kReverse && !_actuateOutward);
    }
}
