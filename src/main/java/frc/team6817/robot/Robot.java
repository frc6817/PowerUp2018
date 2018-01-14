package frc.team6817.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team6817.robot.Autonomous.AutoLine;
import frc.team6817.robot.Subsystems.Drivetrain;


public class Robot extends TimedRobot
{
    private static final Drivetrain _drivetrain = new Drivetrain();

    private static OI _oi;

    private SendableChooser<CommandGroup> _autoChooser = new SendableChooser<>();   // Auto chooser


    /**
     * Initializes controls and adds autonomous chooser element to the SmartDashboard
     */
    @Override
    public void robotInit()
    {
        _oi = new OI(0 , 1);

        _autoChooser.addDefault("Baseline Auto" , new AutoLine());
        SmartDashboard.putData("Auto mode" , _autoChooser);
    }


    @Override
    public void disabledInit()
    {
        _drivetrain.stop();
    }


    /**
     * Grabs the current selected autonomous from the SmartDashboard and starts it
     */
    @Override
    public void autonomousInit()
    {
        CommandGroup auto = _autoChooser.getSelected();

        if(auto != null)
        {
            auto.start();
        }
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


    /**
     * Called periodically in autonomous- runs the scheduler
     */
    @Override
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }


    /**
     * Called periodically in teleOp- runs the scheduler
     */
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