package frc.team6817.robot;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team6817.robot.Autonomous.FMSReader;
import frc.team6817.robot.Subsystems.BlockIntake;
import frc.team6817.robot.Subsystems.Drivetrain;
import frc.team6817.robot.Subsystems.Flip;
import frc.team6817.robot.Subsystems.TapeMeasure;


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
    public static final BlockIntake blockIntake = new BlockIntake();
    public static final Flip flip = new Flip();
    public static final TapeMeasure tapeMeasure = new TapeMeasure();
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



        if(_oi.controller2().getBButtonPressed())
        {
            flip.setState(Flip.State.FLIPENC);
            flip.setState(Flip.State.UNFLIPENC);
            flip.setState(Flip.State.STOP);
        }
        else if(_oi.controller2().getTriggerAxis(GenericHID.Hand.kRight) > .20)
        {
            flip.setState(Flip.State.FLIP);
        }
        else if(_oi.controller2().getTriggerAxis(GenericHID.Hand.kLeft)>.20)
        {
            flip.setState(Flip.State.UNFLIP);
        }
        else
        {
            flip.setState(Flip.State.STOP);
        }


        if(_oi.controller1().getTriggerAxis(GenericHID.Hand.kRight) > .20)
        {
            tapeMeasure.setState(TapeMeasure.State.UNWIND);
        }
        else if(_oi.controller1().getTriggerAxis(GenericHID.Hand.kLeft) > .20)
        {
            tapeMeasure.setState(TapeMeasure.State.WIND);
        }
        else
        {
            tapeMeasure.setState(TapeMeasure.State.STOP);
        }

        SmartDashboard.putNumber("Yaw" , RobotMap.navx.getYaw());
        SmartDashboard.putNumber("Pitch" , RobotMap.navx.getPitch());
        SmartDashboard.putNumber("Roll" , RobotMap.navx.getRoll());
    }


    @Override
    public void testPeriodic()
    {

    }
}