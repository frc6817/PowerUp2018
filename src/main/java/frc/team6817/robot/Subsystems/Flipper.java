package frc.team6817.robot.Subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.team6817.robot.Commands.Flipper.ManualFlip;

import static frc.team6817.robot.RobotMap.flipController;


public class Flipper extends PIDSubsystem
{
    public static final double COUNTS_PER_DEGREE = 227.56;


    public Flipper()
    {
        super(2 , 0 , 0);

        flipController.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute , 0 , 0);

        setAbsoluteTolerance(2 * COUNTS_PER_DEGREE);
        setInputRange(-9_999_999 , 9_999_999);          // Hecka large numbers xd
        setOutputRange(-1 , 1);
        getPIDController().setContinuous();
    }


    @Override
    protected void initDefaultCommand()
    {
        setDefaultCommand(new ManualFlip());
    }


    /**
     * Stops the motors
     */
    public void stop()
    {
        flipController.set(ControlMode.PercentOutput , 0);
    }


    @Override
    protected double returnPIDInput()
    {
        return flipController.getSensorCollection().getQuadraturePosition();
    }


    @Override
    protected void usePIDOutput(double output)
    {
        flipController.set(ControlMode.PercentOutput , output);
    }
}
