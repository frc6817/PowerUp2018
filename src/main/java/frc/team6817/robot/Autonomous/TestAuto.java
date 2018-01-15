package frc.team6817.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team6817.robot.Commands.DriveForTime;


public class TestAuto extends CommandGroup
{
    public TestAuto()
    {
        if(FMSReader.nearSwitch() == 'L')
        {
            addSequential(new DriveForTime(.5 , .5 ,500));
        }
        else
        {
            addSequential(new DriveForTime(-.5 , -.5 , 500));
        }
    }
}