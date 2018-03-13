package frc.team6817.robot;


import edu.wpi.first.wpilibj.CameraServer;


/**
 * Wrapper class for the camera- allows for future expansion should the need arise.
 */
@SuppressWarnings("ALL")
public class CameraManager
{
    /**
     * Starts the camera manager- sets up a USB camera stream which is sent to an output stream at:
     *
     * roborio-6817-frc.local:1181/?action=stream
     */
    public static void start()
    {
        CameraServer.getInstance().startAutomaticCapture("front camera" , 1);
    }
}
