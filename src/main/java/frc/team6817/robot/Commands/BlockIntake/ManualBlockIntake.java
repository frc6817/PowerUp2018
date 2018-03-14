package frc.team6817.robot.Commands.BlockIntake;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.RobotMap.*;


public class ManualBlockIntake extends Command
{
    public static double THROTTLE = .5;


    public ManualBlockIntake()
    {
        super();

        requires(blockIntake);
    }


    @Override
    public void execute()
    {
        double intakePower = -OI.controller2().getTriggerAxis(GenericHID.Hand.kLeft);

        if(OI.controller2().getTriggerAxis(GenericHID.Hand.kRight) > 0)
        {
            intakePower = OI.controller2().getTriggerAxis(GenericHID.Hand.kRight);
        }

        if(OI.controller2().getBumperPressed(GenericHID.Hand.kLeft))
        {
            dualIntake.set(DoubleSolenoid.Value.kForward);
        }
        else if(OI.controller2().getBumperPressed(GenericHID.Hand.kRight))
        {
            dualIntake.set(DoubleSolenoid.Value.kReverse);
        }

        leftIntakeController.set(intakePower * THROTTLE);
        rightIntakeController.set(-intakePower * THROTTLE);
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
        return false;
    }
}
