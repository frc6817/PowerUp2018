package frc.team6817.robot;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team6817.robot.Autonomous.FMSReader;
import frc.team6817.robot.DashServer.DashServer;
import frc.team6817.robot.Subsystems.BlockIntake;
import frc.team6817.robot.Subsystems.Drivetrain;
import frc.team6817.robot.Subsystems.Flipper;
import frc.team6817.robot.Subsystems.Lift;


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
    /** Drivetrain component of the robot */
    public static final Drivetrain drivetrain = new Drivetrain();

    /** Block intake component of the robot */
    public static final BlockIntake blockIntake = new BlockIntake();

    /** Block flipper component of the robot */
    public static final Flipper flipper = new Flipper();

    public static final Lift lift = new Lift();


    /** Autonomous the robot runs during the auto period */
    public static CommandGroup auto;

    public static final DashServer dashServer = new DashServer(6817);


    /**
     * Initializes controls and adds autonomous chooser element to the SmartDashboard. Also starts the camera server.
     */
    @Override
    public void robotInit()
    {
        CameraServer.getInstance().startAutomaticCapture();
        OI.init(0 , 1);

        CameraManager.start();

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
        dashServer.sendMessage("Auto" , " ");

        if(auto != null)
        {
            auto.start();
        }
    }


    @Override
    public void teleopInit()
    {
        dashServer.sendMessage("TeleOp" , " ");

        if(auto != null)
        {
            auto.cancel();
        }


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
        sendInfoToQDash();
    }


    /**
     * Called periodically in autonomous- runs the scheduler
     */
    @Override
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
        sendInfoToQDash();
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
        sendInfoToQDash();

        dashServer.sendMessage("Test" , "Hello from the RoboRio!");


        SmartDashboard.putBoolean("Is Calibrating" , RobotMap.navx.isCalibrating());

        SmartDashboard.putNumber("Yaw" , RobotMap.navx.getYaw());
        SmartDashboard.putNumber("Pitch" , RobotMap.navx.getPitch());
        SmartDashboard.putNumber("Roll" , RobotMap.navx.getRoll());
    }


    @Override
    public void testPeriodic()
    {
        sendInfoToQDash();
    }


    private void sendInfoToQDash()
    {
        dashServer.sendMessage("Yaw" , String.valueOf(RobotMap.navx.getYaw()));
        dashServer.sendMessage("Roll" , String.valueOf(RobotMap.navx.getRoll()));
        dashServer.sendMessage("Pitch" , String.valueOf(RobotMap.navx.getPitch()));

        dashServer.sendMessage("LEnc" , String.valueOf(drivetrain.leftQuadPos()));
        dashServer.sendMessage("REnc" , String.valueOf(drivetrain.rightQuadPos()));
        dashServer.sendMessage("FEnc" , String.valueOf(flipper.pos()));
    }
}