package frc.team6817.robot.Autonomous;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team6817.robot.Commands.BlockIntake.ActuateArms;
import frc.team6817.robot.Commands.Drivetrain.DriveForTime;
import frc.team6817.robot.Commands.Drivetrain.DriveToDistance;
import frc.team6817.robot.Commands.Drivetrain.RotateToDegree;
import frc.team6817.robot.Commands.Flipper.DumpCube;


public class AutoCenter extends CommandGroup
{
    public AutoCenter()
    {
        // Grab cube boi
        addSequential(new DriveToDistance(36));
        addSequential(new DriveToDistance(-36));
        addParallel(new ActuateArms(true));
        addSequential(new DriveToDistance(36));
        addParallel(new ActuateArms(false));


        if(FMSReader.nearSwitch() == 'R')
        {
            addSequential(new RotateToDegree(61));
            addSequential(new DriveToDistance(157));
            addSequential(new RotateToDegree(90));
            addSequential(new DriveToDistance(-10));
            addParallel(new DumpCube());
            addSequential(new DriveForTime(-1 , -1 , 500));

            // Align for exchange running :p
            addSequential(new DriveToDistance(24));
            addSequential(new RotateToDegree(0));
        }
        else
        {
            addSequential(new RotateToDegree(-61));
            addSequential(new DriveToDistance(157));
            addSequential(new RotateToDegree(-90));
            addSequential(new DriveToDistance(-10));
            addParallel(new DumpCube());
            addSequential(new DriveForTime(-1 , -1 , 500));

            // Align for exchange running :p
            addSequential(new DriveToDistance(24));
            addSequential(new RotateToDegree(0));

        }
    }
}
