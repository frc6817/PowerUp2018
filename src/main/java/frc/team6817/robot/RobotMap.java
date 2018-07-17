package frc.team6817.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;


/**
 * For mapping sensors and actuator ports to a variable name. Also holds things such as sensors.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class RobotMap
{
    // Drivetrain controllers
    public static final WPI_TalonSRX frontLeftController = new WPI_TalonSRX(1);
    public static final WPI_TalonSRX frontRightController = new WPI_TalonSRX(2);
    public static final Spark backLeftController = new Spark(1);
    public static final Spark backRightController = new Spark(0);


    // Arms Solenoid
    public static final DoubleSolenoid intakeArms = new DoubleSolenoid(0 , 1);


    // Flipper Controllers
    public static final WPI_VictorSPX flip1 = new WPI_VictorSPX(0);
    public static final WPI_VictorSPX flip2 = new WPI_VictorSPX(1);


    // NavX
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
}
