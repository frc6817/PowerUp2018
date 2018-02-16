package frc.team6817.robot;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team6817.robot.Autonomous.FMSReader;
import frc.team6817.robot.Subsystems.BlockIntake;
import frc.team6817.robot.Subsystems.Drivetrain;
import frc.team6817.robot.Subsystems.Flipper;

import static frc.team6817.robot.RobotMap.leftIntakeController;


/**
 * Main Robot class for Team 6817 POWER UP
 *
 * Declare Subsystems here
 *
 * Robot modes (teleOp , auto , etc.) are defined and controller here
 */
@SuppressWarnings("WeakerAccess")
public class Robot extends TimedRobot
{
    public static final Drivetrain drivetrain = new Drivetrain();
    public static final BlockIntake blockIntake = new BlockIntake();
    public static final Flipper flipper = new Flipper();


    public static final DashServer dashServer = new DashServer(443);


    /**
     * Initializes controls and adds autonomous chooser element to the SmartDashboard. Also starts the camera server.
     */
    @Override
    public void robotInit()
    {
        CameraServer.getInstance().startAutomaticCapture();
        OI.init(0 , 1);

        CameraManager.start();

        TableServer.init();
        TableServer tableServer = new TableServer();
        tableServer.start();

        dashServer.start();
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
        // There's going to be a physical switch that controls which auto to run
        // That code goes here.
    }


    @Override
    public void teleopInit()
    {
        // Be sure to cancel the auto
        /*
            if(myAuto != null)
            {
                myAuto.cancel();
            }
         */

        RobotMap.navx.zeroYaw();
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
     * Does NOT handle command execution- that goes in OI.java
     */
    @Override
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();

//        if(_oi.controller1().getBumperPressed(GenericHID.Hand.kRight))
//        {
//            CameraManager.switchCameras();
//        }


        SmartDashboard.putNumber("Yaw" , RobotMap.navx.getYaw());
        SmartDashboard.putNumber("Pitch" , RobotMap.navx.getPitch());
        SmartDashboard.putNumber("Roll" , RobotMap.navx.getRoll());

//        SmartDashboard.putString("Location" , CameraManager.networkTable().getSubTable("usb:0").getEntry("streams").toString());
//        SmartDashboard.putString("Source" , CameraManager.networkTable().getEntry("source").toString());



        if(OI.controller1().getAButton())
        {
            leftIntakeController.set(0.5);
        }
        else if(OI.controller1().getBButton())
        {
            leftIntakeController.set(-0.5);
        }
        else
        {
            leftIntakeController.set(0.0);
        }
    }


    @Override
    public void testPeriodic()
    {

    }
}