package frc.team6817.robot.Subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.Commands.Winch.ManualWinch;

import static frc.team6817.robot.RobotMap.winchController1;
import static frc.team6817.robot.RobotMap.winchController2;


public class Winch extends Subsystem
{
    private SpeedControllerGroup _winchController = new SpeedControllerGroup(winchController1 , winchController2);


    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new ManualWinch());
    }


    public SpeedControllerGroup controller()
    {
        return _winchController;
    }
}
