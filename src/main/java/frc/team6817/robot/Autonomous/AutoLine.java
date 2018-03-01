package frc.team6817.robot.Autonomous;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team6817.robot.Commands.Drivetrain.DriveToDistance;


/**
 * Auto Line autonomous- crosses the auto line for 5 points
 *
 * A game changer
 */
public class
AutoLine extends CommandGroup
{
    /**
     * Lays out the commands for the AutoLine autonomous
     *
     * 1. Drive past auto line
     */
    public AutoLine()
    {
        addSequential(new DriveToDistance(10.5));
    }
}
