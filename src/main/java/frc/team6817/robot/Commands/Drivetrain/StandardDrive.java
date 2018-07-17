package frc.team6817.robot.Commands.Drivetrain;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.drivetrain;
import static frc.team6817.robot.RobotMap.*;


/**
 * Class that manages the default command of the drivetrain. This is nothing but a cheesy drive implementation.
 *
 * Left stick y controls forward/backward movement, right stick x controls curvature.
 */
public class StandardDrive extends Command
{
    public static double THROTTLE = 1;


    /**
     * Creates a StandardDrive Command- invokes the superconstructor
     */
    public StandardDrive()
    {
        super();

        requires(drivetrain);
    }


    /**
     * Runs the StandardDrive command. This is just an arcade drive split between two sticks
     */
    @Override
    public void execute()
    {
        double leftY = -OI.controller1().getY(GenericHID.Hand.kLeft) * THROTTLE;
        double rightX = OI.controller1().getX(GenericHID.Hand.kRight) * THROTTLE;

        frontLeftController.set(ControlMode.PercentOutput , leftY + rightX);
        backLeftController.set(leftY + rightX);

        frontRightController.set(ControlMode.PercentOutput , -(leftY - rightX));
        backRightController.set(-(leftY - rightX));
    }


    /**
     * Stops the drivetrain upon command interruption
     */
    @Override
    public void interrupted()
    {
        drivetrain.stop();
    }


    /**
     * Stops the drivetrain once the command is finished
     */
    @Override
    public void end()
    {
        drivetrain.stop();
    }


    /**
     * @return Whether this command is finished or not- it always returns false
     */
    @Override
    protected boolean isFinished() {
        return false;
    }
}
