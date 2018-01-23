package frc.team6817.robot;


import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Manages the USB cameras on the robot. For now, all it does is set up the camera server as well as handling camera
 * switching.
 */
public class CameraManager
{
    private static UsbCamera _frontCamera;
    private static UsbCamera _rearCamera;

    private static VideoSink _server;

    private static boolean _seeFrontCamera = true;


    /**
     * Starts the camera manager- sets up USB cameras and dummy sinks to keep both running so that switch delay is
     * minimal.
     */
    public static void start()
    {
        _frontCamera = CameraServer.getInstance().startAutomaticCapture(0);
        _rearCamera = CameraServer.getInstance().startAutomaticCapture(1);
        _server = CameraServer.getInstance().getServer();


        // Set up sinks to keep cameras open and avoid switch delay
        CvSink frontSink = new CvSink("Front Camera");
        frontSink.setSource(_frontCamera);
        frontSink.setEnabled(true);

        CvSink rearSink = new CvSink("Rear Camera");
        rearSink.setSource(_rearCamera);
        rearSink.setEnabled(true);

        _server.setSource(_frontCamera);
    }


    /**
     * Switches which camera the server is pulling from. For example, if the front camera is shown and this method
     * is called, then the rear camera is shown and vice-versa.
     */
    public static void switchCameras()
    {
        if(_seeFrontCamera)
        {
            _server.setSource(_rearCamera);

        }
        else
        {
            _server.setSource(_frontCamera);
        }

        _seeFrontCamera = !_seeFrontCamera;
    }
}
