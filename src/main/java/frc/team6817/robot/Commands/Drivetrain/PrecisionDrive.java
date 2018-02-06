package frc.team6817.robot.Commands.Drivetrain;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.drivetrain;


/**
 * Class that manages the precision driving command of the drivetrain. This is the standard drive command, except
 * a multiplier is added on top of the given input. Right now, this multiplier is .5
 */
public class PrecisionDrive extends Command
{
    /**
     * Creates a PrevisionDrive command- invokes supercontructor
     */
    public PrecisionDrive()
    {
        super();

        requires(drivetrain);
    }


    /**
     * Runs the PrecisionDrive command- this sets the throttle to half speed
     */
    @Override
    public void execute()
    {
        final double speedMultiplier = .5;

        double leftY = OI.controller1().getY(GenericHID.Hand.kLeft) * speedMultiplier;
        double rightX = OI.controller1().getX(GenericHID.Hand.kRight) * speedMultiplier;

        drivetrain.drive.curvatureDrive(leftY , rightX , leftY < .05);

        SmartDashboard.putString("Precision Drive" , "On");
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
    protected boolean isFinished()
    {
        return false;
    }
}
