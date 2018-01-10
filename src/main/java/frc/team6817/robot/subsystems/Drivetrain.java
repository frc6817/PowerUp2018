package frc.team6817.robot.subsystems;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Drivetrain extends Subsystem
{
    private Talon _lfController = new Talon(0);
    private Talon _lrController = new Talon(1);
    private Talon _rfController = new Talon(2);
    private Talon _rrController = new Talon(3);

    private SpeedControllerGroup _lGroup = new SpeedControllerGroup(_lfController, _lrController);
    private SpeedControllerGroup _rGroup = new SpeedControllerGroup(_rfController, _rrController);

    private DifferentialDrive _drive = new DifferentialDrive(_lGroup , _rGroup);


    @Override
    protected void initDefaultCommand()
    {
        // Nothing :)
    }


    /**
     * Drives the drivetrain in TeleOp. Skrrt skrrt.
     *
     * @param driver XBox controller that drives the drivetrain
     */
    public void teleOpDrive(XboxController driver)
    {
        _drive.arcadeDrive(driver.getY(GenericHID.Hand.kLeft) , driver.getX(GenericHID.Hand.kRight));
    }


    /**
     * Stops the drivetrain
     */
    public void stop()
    {
        _drive.stopMotor();
    }
}
