package frc.team6817.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team6817.robot.Commands.Drivetrain.PrecisionDrive;


/**
 * For binding controls to robot commands
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class OI
{
    // Controllers
    private static XboxController _controller1;
    private static XboxController _controller2;

    // Buttons, 1 at the end denotes controller 1, 2 denotes controller 2
    private static Button a1;
    private static Button b1;
    private static Button x1;
    private static Button y1;
    private static Button lBumper1;
    private static Button rBumper1;
    private static Button back1;
    private static Button start1;
    private static Button lStick1;
    private static Button rStick1;

    private static Button a2;
    private static Button b2;
    private static Button x2;
    private static Button y2;
    private static Button lBumper2;
    private static Button rBumper2;
    private static Button back2;
    private static Button start2;
    private static Button lStick2;
    private static Button rStick2;


    /**
     * Sets the controller ports
     */
    @SuppressWarnings("SameParameterValue")
    static void init(final int PORT1 , final int PORT2)
    {
        _controller1 = new XboxController(PORT1);
        _controller2 = new XboxController(PORT2);


        a1 = new JoystickButton(_controller1 , 1);
        b1 = new JoystickButton(_controller1 , 2);
        x1 = new JoystickButton(_controller1 , 3);
        y1 = new JoystickButton(_controller1 , 4);
        lBumper1 = new JoystickButton(_controller1 , 5);
        rBumper1 = new JoystickButton(_controller1 , 6);
        back1 = new JoystickButton(_controller1 , 7);
        start1 = new JoystickButton(_controller1 , 8);
        lStick1 = new JoystickButton(_controller1 , 9);
        rStick1 = new JoystickButton(_controller1 , 10);

        a2 = new JoystickButton(_controller2 , 1);
        b2 = new JoystickButton(_controller2 , 2);
        x2 = new JoystickButton(_controller2 , 3);
        y2 = new JoystickButton(_controller2 , 4);
        lBumper2 = new JoystickButton(_controller2 , 5);
        rBumper2 = new JoystickButton(_controller2 , 6);
        back2 = new JoystickButton(_controller2 , 7);
        start2 = new JoystickButton(_controller2 , 8);
        lStick2 = new JoystickButton(_controller2 , 9);
        rStick2 = new JoystickButton(_controller2 , 10);


        // Tie buttons to commands
        lStick1.toggleWhenPressed(new PrecisionDrive());
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
