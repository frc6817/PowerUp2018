package frc.team6817.robot.Autonomous;


import edu.wpi.first.wpilibj.DriverStation;


/**
 * Class for managing the autonomous data from the FMS
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FMSReader
{
    private static String _data = "   ";    // String of spaces to protect against null pointer


    /**
     * Reads data from the FMS. Call this in a fast loop (~20 ms) or at the start of
     * autonomous init
     */
    public static void readFMS()
    {
        _data = DriverStation.getInstance().getGameSpecificMessage();
    }


    /**
     * @return Data character of the near switch
     */
    public static char nearSwitch()
    {
        return _data.charAt(0);
    }


    /**
     * @return Data character of the scale
     */
    public static char scale()
    {
        return  _data.charAt(1);
    }


    /**
     * @return Data character of the far switch
     */
    public static char farScale()
    {
        return _data.charAt(2);
    }
}
