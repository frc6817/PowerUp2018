package frc.team6817.robot.Subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.Commands.Drivetrain.StandardDrive;

import static frc.team6817.robot.RobotMap.*;


/**
 * Drivetrain subsystem of the Power Up robot. It is a 6-wheel drop center running 4 motors,
 * two on each side running the Cheesy Drive.
 */
public class Drivetrain extends Subsystem
{
    /**
     * Initializes drivetrain motor controllers. For the drivetrain, each side's Victor SPX follows its corresponding
     * Talon SRX. Adjustments to the drivetrain should only be done through the Talon SRXs.
     */
    public Drivetrain()
    {
        backLeftController.follow(frontLeftController);
        backRightController.follow(frontRightController);
    }


    /**
     * Drives the drivetrain in TeleOp using an automatic version of the Cheesy Drive. QuickTurn is run
     * when the forward/backward throttle is less than .05
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
