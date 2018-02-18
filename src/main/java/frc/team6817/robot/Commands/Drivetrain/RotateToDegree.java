package frc.team6817.robot.Commands.Drivetrain;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.team6817.robot.RobotMap;

import static frc.team6817.robot.Robot.drivetrain;
import static frc.team6817.robot.RobotMap.frontLeftController;
import static frc.team6817.robot.RobotMap.frontRightController;


public class RotateToDegree extends PIDCommand
{
    private final double TOLERANCE = 1.5;


    public RotateToDegree(final double DESTINATION)
    {
        super(2 , 0 , 0 );

        requires(drivetrain);

        getPIDController().setAbsoluteTolerance(TOLERANCE);
        getPIDController().setContinuous();
        setSetpoint(DESTINATION);
    }


    @Override
    protected double returnPIDInput()
    {
        return RobotMap.navx.getPitch();
    }


    @Override
    protected void usePIDOutput(double output)
    {
        frontRightController.set(ControlMode.PercentOutput , output);
        frontLeftController.set(ControlMode.PercentOutput , -output);
    }


    @Override
    protected boolean isFinished()
    {
        return Math.abs(RobotMap.navx.getPitch() - getSetpoint()) <= TOLERANCE;
    }
}
