package frc.team6817.robot.Commands.Drivetrain;


import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.team6817.robot.RobotMap;

import static frc.team6817.robot.Robot.drivetrain;
import static frc.team6817.robot.RobotMap.frontLeftController;
import static frc.team6817.robot.RobotMap.frontRightController;


/**
 * Command that requests the robot to drive to a certain distance in inches.
 */
@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess"})
public class DriveToDistance extends PIDCommand
{
    public static double COUNTS_PER_INCH = 210.7;
    public static int TOLERANCE = 100;

    public static double P = 0;
    public static double I = 0;
    public static double D = 0;


    /**
     * Initializes standard PID variables
     *
     * @param DISTANCE Distance to drive the robot to in INCHES
     */
    public DriveToDistance(final double DISTANCE)
    {
        super(P , I , D);

        requires(drivetrain);

        getPIDController().setAbsoluteTolerance(TOLERANCE);
        getPIDController().setContinuous();

        // This is the setpoint in ENCODER COUNTS, NOT INCHES
        setSetpoint(DISTANCE * COUNTS_PER_INCH);
    }


    /**
     * @return Average quadrature position between both left side and right side of the drivetrain.
     */
    @Override
    protected double returnPIDInput()
    {
        // Average of the encoder values
        return (frontLeftController.getSensorCollection().getQuadraturePosition() +
                frontRightController.getSensorCollection().getQuadraturePosition()) / 2;
    }


    /**
     * Sets the PID output to both sides of the drivetrain.
     *
     * @param output Output from PID object
     */
    @Override
    protected void usePIDOutput(double output)
    {
        RobotMap.frontLeftController.set(output);
        RobotMap.frontRightController.set(output);
    }


    /**
     * @return True if the average quadrature positions of the drivetrain is within the tolerance of the destination.
     * False otherwise.
     */
    @Override
    protected boolean isFinished()
    {
        // If the absolute value of the (average of the encoder positions minus the setpoint) is less than or equal
        // to the tolerance
        return Math.abs((frontLeftController.getSensorCollection().getQuadraturePosition()
                + frontRightController.getSensorCollection().getQuadraturePosition()) / 2 - this.getSetpoint())
                <= TOLERANCE;
    }
}
