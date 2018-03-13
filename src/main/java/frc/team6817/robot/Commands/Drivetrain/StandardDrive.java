package frc.team6817.robot.Commands.Drivetrain;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.drivetrain;
import static frc.team6817.robot.RobotMap.frontLeftController;
import static frc.team6817.robot.RobotMap.frontRightController;


/**
 * Class that manages the default command of the drivetrain. This is nothing but a cheesy drive implementation.
 *
 * Left stick y controls forward/backward movement, right stick x controls curvature.
 */
public class StandardDrive extends Command
{
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
        double leftY = OI.controller1().getY(GenericHID.Hand.kLeft);
        double rightX = OI.controller1().getX(GenericHID.Hand.kRight);

        drivetrain.setLeftPower(leftY - rightX);
        drivetrain.setRightPower(leftY + rightX);

        SmartDashboard.putNumber("Left Encoder" , drivetrain.leftQuadPos());
        SmartDashboard.putNumber("Right Encoder" , drivetrain.rightQuadPos());

        SmartDashboard.putNumber("Left Quad" , frontLeftController.getSensorCollection().getQuadraturePosition());
        SmartDashboard.putNumber("Right Quad" , frontRightController.getSensorCollection().getQuadraturePosition());

        SmartDashboard.putString("Precision Drive" , "Off");
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
