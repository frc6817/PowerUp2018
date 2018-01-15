package frc.team6817.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team6817.robot.Autonomous.AutoLine;
import frc.team6817.robot.Autonomous.FMSReader;
import frc.team6817.robot.Autonomous.TestAuto;
import frc.team6817.robot.Subsystems.Drivetrain;


public class Robot extends TimedRobot
{
    public static final Drivetrain drivetrain = new Drivetrain();

    private static OI _oi;

    private SendableChooser<Command> _autoChooser = new SendableChooser<>();       // Auto chooser


    /**
     * Initializes controls and adds autonomous chooser element to the SmartDashboard. Also starts the camera server.
     */
    @Override
    public void robotInit()
    {
        _oi = new OI(0 , 1);

        _autoChooser.addDefault("Baseline Auto" , new AutoLine());
        _autoChooser.addObject("Test Auto" , new TestAuto());
        SmartDashboard.putData("Auto mode" , _autoChooser);

        CameraManager.start();
    }


    @Override
    public void disabledInit()
    {
        drivetrain.stop();
    }


    /**
     * Grabs the current selected autonomous from the SmartDashboard and starts it
     */
    @Override
    public void autonomousInit()
    {
        if(_autoChooser.getSelected() != null)
        {
            _autoChooser.getSelected().start();
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
        FMSReader.readFMS();
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
     *
     * Also handles controls not defined as commands (ex. Camera Switching)
     */
    @Override
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();

        drivetrain.teleOpDrive(_oi.controller1());

        if(_oi.controller1().getBumperPressed(GenericHID.Hand.kRight))
        {
            CameraManager.switchCameras();
        }
    }


    @Override
    public void testPeriodic()
    {

    }
}