package frc.team6817.robot;


import edu.wpi.first.wpilibj.XboxController;


/**
 * For binding controls to robot commands
 */
public class OI
{
    private XboxController controller1;
    private XboxController controller2;


    /**
     * Constructor- takes two ports and sets the controllers to them
     *
     * @param PORT1 The port controller one belongs to
     * @param PORT2 The port controller two belongs to
     */
    public OI(final int PORT1 , final int PORT2)
    {
        controller1 = new XboxController(PORT1);
        controller2 = new XboxController(PORT2);
    }


    /**
     * @return Returns the first Xbox controller
     */
    public XboxController controller1()
    {
        return controller1;
    }


    /**
     * @return Returns the second Xbox controller
     */
    public XboxController controller2()
    {
        return controller2;
    }
}
