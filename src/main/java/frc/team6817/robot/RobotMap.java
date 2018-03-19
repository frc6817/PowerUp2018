package frc.team6817.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;


/**
 * For mapping sensors and actuator ports to a variable name. Also holds things such as sensors.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class RobotMap
{
    // Drivetrain controllers
    public static final WPI_TalonSRX frontLeftController = new WPI_TalonSRX(1);
    public static final WPI_TalonSRX frontRightController = new WPI_TalonSRX(2);
    public static final WPI_VictorSPX backLeftController = new WPI_VictorSPX(0);
    public static final WPI_VictorSPX backRightController = new WPI_VictorSPX(1);


    // Block Intake controllers
    public static final Spark leftIntakeController = new Spark(9);
    public static final Spark rightIntakeController = new Spark(2);


    public static final DoubleSolenoid dualIntake = new DoubleSolenoid(3 , 4);


    // Flipper Controller
    public static final WPI_TalonSRX flipController = new WPI_TalonSRX(0);


    // Lift Controller
    public static final Spark liftController = new Spark(8);


    // Winch Controller
    public static final VictorSP winchController1 = new VictorSP(3);
    public static final Spark winchController2 = new Spark(4);


    // NavX
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
}
