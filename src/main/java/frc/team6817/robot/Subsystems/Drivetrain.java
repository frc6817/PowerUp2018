package frc.team6817.robot.Subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.Commands.Drivetrain.StandardDrive;

import static frc.team6817.robot.RobotMap.*;


/**
 * Drivetrain subsystem of the Power Up robot. It is a 6-wheel drop center running 4 motors,
 * two on each side running the Cheesy Drive.
 */
@SuppressWarnings("WeakerAccess")
public class Drivetrain extends Subsystem
{
    private long _leftOffset = 0;
    private long _rightOffset = 0;


    /**
     * Initializes drivetrain motor controllers. For the drivetrain, each side's Victor SPX follows its corresponding
     * Talon SRX. Adjustments to the drivetrain should only be done through the Talon SRXs.
     */
    public Drivetrain()
    {
        backLeftController.follow(frontLeftController);
        backRightController.follow(frontRightController);

        frontLeftController.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute , 0 , 0);
        frontRightController.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute , 0 , 0);

        resetEncoders();
    }


    /**
     * Manages the setting of the left drivetrain power. Because the motors on the left side spin the
     * opposite direction, they are wrapped such that they will spin backwards and therefore forwards relative to
     * us.
     *
     * @param power Power level between [-1 , 1] to set to the left side
     */
    public void setLeftPower(double power)
    {
        frontLeftController.set(ControlMode.PercentOutput , -power);
    }


    /**
     * Manages the setting of the right drivetrain power. For now, just sets the drivetrain power as the power provided
     *
     * @param power Power level between [-1 , 1] to set to the right side
     */
    public void setRightPower(double power)
    {
        frontRightController.set(ControlMode.PercentOutput , power);
    }



    /**
     * @return Position of the left drivetrain quadrature. If an offset has been implemented, then it is subtracted off
     */
    public long leftQuadPos()
    {
        return -(frontLeftController.getSelectedSensorPosition(0) - _leftOffset);
    }


    /**
     * @return Position of the right drivetrain quadrature. If an offset has been implemented, then it is subtracted off
     */
    public long rightQuadPos()
    {
        return frontRightController.getSelectedSensorPosition(0) - _rightOffset;
    }


    /**
     * Performs a "soft" reset by creating an offset to 0. This offset is then subtracted off the raw encoder amounts
     */
    public void resetEncoders()
    {
        _leftOffset = frontLeftController.getSelectedSensorPosition(0);
        _rightOffset = frontRightController.getSelectedSensorPosition(0);
    }


    /**
     * Drives the drivetrain in TeleOp using a split version of the arcade drive.
     *
     * Skrrt skrrt.
     */
    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new StandardDrive());
    }


    /**
     * Stops the drivetrain
     */
    public void stop()
    {
        frontLeftController.set(ControlMode.PercentOutput , 0);
        frontRightController.set(ControlMode.PercentOutput , 0);
    }
}
