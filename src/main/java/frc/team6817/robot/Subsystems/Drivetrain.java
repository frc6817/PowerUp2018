package frc.team6817.robot.Subsystems;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team6817.robot.OI;

import static frc.team6817.robot.RobotMap.*;


/**
 * Drivetrain subsystem of the Power Up robot. It is a 6-wheel drop center running 4 motors,
 * two on each side running the Cheesy Drive.
 */
public class Drivetrain extends Subsystem
{
    private SpeedControllerGroup _lGroup = new SpeedControllerGroup(lfController, lrController);
    private SpeedControllerGroup _rGroup = new SpeedControllerGroup(rfController, rrController);

    public final DifferentialDrive drive = new DifferentialDrive(_lGroup , _rGroup);

    private boolean _slowOn = false;


    /**
     * Drives the drivetrain in TeleOp using an automatic version of the Cheesy Drive. QuickTurn is run
     * when the forward/backward throttle is less than .05
     *
     * Skrrt skrrt.
     */
    @Override
    protected void initDefaultCommand()
    {
        double leftY = OI.controller1().getY(GenericHID.Hand.kLeft);
        double rightX = OI.controller1().getX(GenericHID.Hand.kRight);

        drive.curvatureDrive(leftY , rightX , leftY < .05);
    }


    /**
     * Drives the drivetrain given a leftPower and a rightPower. Runs tank drive configuration.
     *
     * @param leftPower Power to apply to the left side
     * @param rightPower Power to apply to the right side
     * @param scale Whether to scale power or not
     */
    public void tankDrive(double leftPower , double rightPower , boolean scale)
    {
        drive.tankDrive(leftPower, rightPower, scale);
    }


    /**
     * Toggles on or off slow mode (50% drivetrain power)
     */
    public void toggleSlow()
    {
        _slowOn = !_slowOn;
    }


    /**
     * @return Whether the drivetrain is in slow mode or not
     */
    public boolean isSlow()
    {
        return _slowOn;
    }


    /**
     * Stops the drivetrain
     */
    public void stop()
    {
        drive.stopMotor();
    }
}
