package frc.team6817.robot;


import edu.wpi.first.wpilibj.Spark;


/**
 * For mapping sensors and actuator ports to a variable name
 */
@SuppressWarnings("unused")
public class RobotMap
{
    // Drivetrain controllers
    public static final Spark lfController = new Spark(1);
    public static final Spark lrController = new Spark(0);
    public static final Spark rfController = new Spark(3);
    public static final Spark rrController = new Spark(2);
}
