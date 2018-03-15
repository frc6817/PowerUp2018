package frc.team6817.robot.Commands.Winch;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.winch;


public class ManualWinch extends Command
{
    public ManualWinch()
    {
        super();

        requires(winch);
    }


    @Override
    public void execute()
    {
        double powerLevel = 0;

        if(OI.controller1().getBumperPressed(GenericHID.Hand.kRight))
        {
            powerLevel = 75;
        }
        else if(OI.controller1().getBumperPressed(GenericHID.Hand.kLeft))
        {
            powerLevel = -.75;
        }

        winch.controller().set(powerLevel);
    }


    @Override
    public void interrupted()
    {
        winch.controller().stopMotor();
    }


    @Override
    public void end()
    {
        winch.controller().stopMotor();
    }


    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
