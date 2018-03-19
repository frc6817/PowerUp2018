package frc.team6817.robot.Subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.Commands.Lift.ManualLift;


public class Lift extends Subsystem
{
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new ManualLift());
    }
}
