package frc.team6817.robot.Commands.Flipper;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.flipper;
import static frc.team6817.robot.RobotMap.flipController;


public class ManualFlip extends Command
{
    public static double THROTTLE = .60;


    public ManualFlip()
    {
        super();

        requires(flipper);
    }


    @Override
    public void execute()
    {
        double powerLevel = OI.controller2().getY(GenericHID.Hand.kRight);

        flipController.set(ControlMode.PercentOutput , powerLevel * THROTTLE);
    }


    @Override
    public void interrupted()
    {
        flipper.stop();
    }


    @Override
    public void end()
    {
        flipper.stop();
    }


    @Override
    protected boolean isFinished()
    {
        return false;
    }
}