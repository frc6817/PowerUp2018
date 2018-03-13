package frc.team6817.robot.Commands.Drivetrain;


import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.team6817.robot.RobotMap;

import static frc.team6817.robot.Robot.drivetrain;


/**
 * Command that requests the drivetrain to rotate to a particular angle relative to its calibration position.
 */
@SuppressWarnings("WeakerAccess")
public class RotateToDegree extends PIDCommand
{
    public static double TOLERANCE = 1.5;

    public static double P = 2;
    public static double I = 1;
    public static double D = .25;


    /**
     * Creates the RotateToDegree command by setting up the target angle. It also restricts the input range to
     * [-180 , 180] and the output range to [-1 , 1]
     *
     * @param DESTINATION Destination angle in degrees
     */
    public RotateToDegree(final double DESTINATION)
    {
        super(P , I , D );

        requires(drivetrain);

        getPIDController().setAbsoluteTolerance(TOLERANCE);

        setInputRange(-180 , 180);
        getPIDController().setOutputRange(-1 , 1);

        getPIDController().setContinuous();
        setSetpoint(DESTINATION);
    }


    /**
     * @return Yaw of the robot
     */
    @Override
    protected double returnPIDInput()
    {
        return RobotMap.navx.getYaw();
    }


    /**
     * Sets the robot to turn using the output provided by the PID object
     *
     * @param output Output between [-1 , 1] provided by the PID object
     */
    @Override
    protected void usePIDOutput(double output)
    {
        drivetrain.setLeftPower(-output);   // Negate so that the robot turns
        drivetrain.setRightPower(output);
    }


    /**
     * @return True if the yaw is within tolerance of the target. False otherwise.
     */
    @Override
    protected boolean isFinished()
    {
        return Math.abs(RobotMap.navx.getYaw() - getSetpoint()) <= TOLERANCE;
    }
}
