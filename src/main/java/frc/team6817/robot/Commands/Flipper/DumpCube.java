package frc.team6817.robot.Commands.Flipper;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team6817.robot.Commands.BlockIntake.ActuateArms;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.Robot.flipper;


public class DumpCube extends CommandGroup
{
    public void DumpCube()
    {
        requires(flipper);
        requires(blockIntake);

        addSequential(new ActuateArms(true));
        addSequential(new FlipperToPosition(FlipperToPosition.Position.TOP));
        addSequential(new FlipperToPosition(FlipperToPosition.Position.BOTTOM));
    }
}
