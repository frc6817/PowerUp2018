package frc.team6817.robot.Autonomous;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team6817.robot.Commands.BlockIntake.ActuateArms;
import frc.team6817.robot.Commands.Drivetrain.DriveForTime;
import frc.team6817.robot.Commands.Drivetrain.DriveToDistance;
import frc.team6817.robot.Commands.Drivetrain.RotateToDegree;
import frc.team6817.robot.Commands.Flipper.DumpCube;


public class AutoLeft extends CommandGroup
{
    public AutoLeft()
    {
        // Grab cube boi
        addSequential(new DriveToDistance(24));
        addSequential(new DriveToDistance(-24));
        addParallel(new ActuateArms(true));
        addSequential(new DriveToDistance(24));
        addParallel(new ActuateArms(false));


        if(FMSReader.nearSwitch() == 'L')
        {
            addSequential(new DriveToDistance(120));

            addSequential(new RotateToDegree(90));

            addParallel(new DumpCube());
            addSequential(new DriveForTime(-1 , -1 , 500));

            // Align for exchange running :p
            addSequential(new DriveToDistance(24));
            addSequential(new RotateToDegree(0));
        }
        else
        {
            
        }
    }
}
