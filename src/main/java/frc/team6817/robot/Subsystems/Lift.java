package frc.team6817.robot.Subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.Commands.Flipper.ManualFlip;


public class Lift extends Subsystem
{
    public Lift()
    {
        // Nothing
    }


    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new ManualFlip());
    }
}
