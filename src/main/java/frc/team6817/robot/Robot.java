package frc.team6817.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team6817.robot.subsystems.Drivetrain;


public class Robot extends TimedRobot
{
    private static final Drivetrain _drivetrain = new Drivetrain();

    private static OI _oi;


    @Override
    public void robotInit()
    {
        _oi = new OI(0 , 1);
    }


    @Override
    public void disabledInit()
    {

    }


    @Override
    public void autonomousInit()
    {

    }


    @Override
    public void teleopInit()
    {

    }


    @Override
    public void testInit()
    {

    }


    @Override
    public void disabledPeriodic()
    {

    }


    @Override
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }


    @Override
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();

        _drivetrain.teleOpDrive(_oi.controller1());
    }


    @Override
    public void testPeriodic()
    {

    }
}