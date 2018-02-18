package frc.team6817.robot.Commands.BlockIntake;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.RobotMap.leftIntakeController;
import static frc.team6817.robot.RobotMap.rightIntakeController;


public class ManualBlockIntake extends Command
{
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

        if(OI.controller2().getBumperPressed(GenericHID.Hand.kRight))
        {
            new ActuateArms(false).execute();
        }
        else if(OI.controller2().getBumperPressed(GenericHID.Hand.kLeft))
        {
            new ActuateArms(true).execute();
        }

        leftIntakeController.set(intakePower);
        rightIntakeController.set(intakePower);
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
