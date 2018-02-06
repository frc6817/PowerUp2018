package frc.team6817.robot;


import edu.wpi.first.wpilibj.XboxController;


/**
 * For binding controls to robot commands
 */
public class OI
{
    private static XboxController _controller1;
    private static XboxController _controller2;


    /**
     * Sets the controller ports
     */
    public static void setPorts(final int PORT1 , final int PORT2)
    {
        _controller1 = new XboxController(PORT1);
        _controller2 = new XboxController(PORT2);
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
