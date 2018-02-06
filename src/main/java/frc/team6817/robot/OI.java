package frc.team6817.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team6817.robot.Commands.Drivetrain.PrecisionDrive;


/**
 * For binding controls to robot commands
 */
public class OI
{
    // Controllers
    private static XboxController _controller1;
    private static XboxController _controller2;

    // Buttons
    private static Button a1;


    /**
     * Sets the controller ports
     */
    @SuppressWarnings("SameParameterValue")
    static void setPorts(final int PORT1 , final int PORT2)
    {
        _controller1 = new XboxController(PORT1);
        _controller2 = new XboxController(PORT2);

        a1 = new JoystickButton(_controller1 , 1);
    }


    /**
     * Initializes the OI class and controller mappings- be sure to call this when the robot initializes
     */
    static void init()
    {
        a1.toggleWhenPressed(new PrecisionDrive());
    }


    /**
     * @return Returns the first Xbox controller
     */
    public static XboxController controller1()
    {
        return _controller1;
    }


    /**
     * @return Returns the second Xbox controller
     */
    public static XboxController controller2()
    {
        return _controller2;
    }
}
