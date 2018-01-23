package frc.team6817.robot;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;


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


    // Block Intake controllers
    public static final Victor lIntakeController = new Victor(4);
    public static final Victor rIntakeController = new Victor(5);
    public static final Victor mIntakeController = new Victor(6);

    //Lift Controllers
    public static final Talon liftController1 = new Talon(7);
    public static final Talon liftController2 = new Talon(8);
    public static final Talon liftController3 = new Talon(9);
    public static final Talon liftController4 = new Talon(10);
}
