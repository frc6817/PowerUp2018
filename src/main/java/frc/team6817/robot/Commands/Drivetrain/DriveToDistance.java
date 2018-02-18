package frc.team6817.robot.Commands.Drivetrain;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.PIDCommand;

import static frc.team6817.robot.Robot.drivetrain;
import static frc.team6817.robot.RobotMap.frontLeftController;
import static frc.team6817.robot.RobotMap.frontRightController;


@SuppressWarnings("FieldCanBeLocal")
public class DriveToDistance extends PIDCommand
{
    private final double COUNTS_PER_INCH = 2770.57;
    private final int TOLERANCE = 1_000;


    /**
     * Initializes standard PID variables
     */
    public DriveToDistance(final double DISTANCE)
    {
        super(2.0 , 0.0 , 0.0);

        requires(drivetrain);

        getPIDController().setAbsoluteTolerance(TOLERANCE);
        getPIDController().setContinuous();

        // This is the setpoint in ENCODER COUNTS, NOT INCHES
        setSetpoint(DISTANCE * COUNTS_PER_INCH);
    }


    @Override
    protected double returnPIDInput()
    {
        // Average of the encoder values
        return (frontLeftController.getSensorCollection().getQuadraturePosition() + frontRightController.getSensorCollection().getQuadraturePosition()) / 2;
    }


    @Override
    protected void usePIDOutput(double output)
    {
        frontLeftController.set(ControlMode.PercentOutput , output);
        frontRightController.set(ControlMode.PercentOutput , output);
    }

    @Override
    protected boolean isFinished()
    {
        // If the absolute value of the (average of the encoder positions minus the setpoint) is less than or equal
        // to the tolerance
        return Math.abs((frontLeftController.getSensorCollection().getQuadraturePosition() + frontRightController.getSensorCollection().getQuadraturePosition()) / 2 - this.getSetpoint()) <= TOLERANCE;
    }
}
