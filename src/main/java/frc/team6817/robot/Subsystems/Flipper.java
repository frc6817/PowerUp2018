package frc.team6817.robot.Subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.Commands.Flipper.ManualFlip;

import static frc.team6817.robot.RobotMap.flipController;


public class Flipper extends Subsystem
{
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new ManualFlip());
    }


    /**
     * Stops the motors
     */
    public void stop()
    {
        flipController.set(ControlMode.PercentOutput , 0);
    }
}
