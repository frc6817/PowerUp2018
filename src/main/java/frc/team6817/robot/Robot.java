package frc.team6817.robot;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team6817.robot.Autonomous.FMSReader;
import frc.team6817.robot.Subsystems.BlockIntake;
import frc.team6817.robot.Subsystems.Drivetrain;
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

    final double TRIGGERBUFFER = .1;
    public static final Drivetrain drivetrain = new Drivetrain();
    public static final Lift lift = new Lift();
    public static final BlockIntake blockIntake = new BlockIntake();

    private static OI _oi;


    /**
     * Initializes controls and adds autonomous chooser element to the SmartDashboard. Also starts the camera server.
     */
    @Override
    public void robotInit()
    {
        CameraServer.getInstance().startAutomaticCapture();
        _oi = new OI(0 , 1);

        CameraManager.start();

        TableServer.init();
        TableServer tableServer = new TableServer();
        tableServer.start();
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

        if(_oi.controller2().getTriggerAxis(GenericHID.Hand.kRight) > TRIGGERBUFFER)
        {
            lift.setState(Lift.State.UP,_oi.controller2().getTriggerAxis(GenericHID.Hand.kRight) );
        }
        else if(_oi.controller2().getTriggerAxis(GenericHID.Hand.kLeft)> TRIGGERBUFFER)
        {
            lift.setState(Lift.State.DOWN,_oi.controller2().getTriggerAxis(GenericHID.Hand.kLeft));
        }
        else
        {
            lift.setState(Lift.State.STOP, 0);
        }

        if(_oi.controller1().getAButtonPressed())
        {
            drivetrain.toggleSlow();
        }


        if(_oi.controller2().getBumper(GenericHID.Hand.kRight))
        {
            blockIntake.setState(BlockIntake.State.IN);
        }
        else if(_oi.controller2().getBumper(GenericHID.Hand.kLeft))
        {
            blockIntake.setState(BlockIntake.State.IN);
        }
        else
        {
            blockIntake.setState(BlockIntake.State.STOP);
        }


        SmartDashboard.putNumber("Yaw" , RobotMap.navx.getYaw());
        SmartDashboard.putNumber("Pitch" , RobotMap.navx.getPitch());
        SmartDashboard.putNumber("Roll" , RobotMap.navx.getRoll());

//        SmartDashboard.putString("Location" , CameraManager.networkTable().getSubTable("usb:0").getEntry("streams").toString());
//        SmartDashboard.putString("Source" , CameraManager.networkTable().getEntry("source").toString());
    }


    @Override
    public void testPeriodic()
    {

    }
}