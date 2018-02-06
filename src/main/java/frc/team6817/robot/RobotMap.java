package frc.team6817.robot;


import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;


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

    //Flip Controller
    public static final Talon flipController1 = new Talon(7);

    //Tape Measure Controller
    public static final Talon tapeController = new Talon (8);

    //Winch Controller
    public static final Talon winchController = new Talon(9);

    // NavX
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
}
