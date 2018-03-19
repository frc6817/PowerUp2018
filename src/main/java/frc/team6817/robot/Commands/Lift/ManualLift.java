package frc.team6817.robot.Commands.Lift;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.lift;
import static frc.team6817.robot.RobotMap.liftController;


public class ManualLift extends Command
{
    public ManualLift()
    {
        super();

        requires(lift);
    }


    @Override
    public void execute()
    {
        double powerLevel = OI.controller1().getTriggerAxis(GenericHID.Hand.kRight);

        if(OI.controller1().getTriggerAxis(GenericHID.Hand.kLeft) > 0)
        {
            powerLevel = -OI.controller1().getTriggerAxis(GenericHID.Hand.kLeft);
        }

        powerLevel *= -.75;

        liftController.set(powerLevel);
    }


    @Override
    public void interrupted()
    {
        liftController.stopMotor();
    }


    @Override
    public void end()
    {
        liftController.stopMotor();
    }


    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
