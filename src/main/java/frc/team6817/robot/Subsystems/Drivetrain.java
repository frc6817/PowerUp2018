package frc.team6817.robot.Subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.Commands.Drivetrain.StandardDrive;

import static frc.team6817.robot.RobotMap.frontLeftController;
import static frc.team6817.robot.RobotMap.frontRightController;


/**
 * Drivetrain subsystem of the Power Up robot. It is a 6-wheel drop center running 4 motors,
 * two on each side running the Cheesy Drive.
 */
@SuppressWarnings("WeakerAccess")
public class Drivetrain extends Subsystem
{
    /**
     * Initializes drivetrain motor controllers. For the drivetrain, each side's Victor SPX follows its corresponding
     * Talon SRX. Adjustments to the drivetrain should only be done through the Talon SRXs.
     */
    public Drivetrain()
    {

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
