package frc.team6817.robot;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;


/**
 * For mapping sensors and actuator ports to a variable name. Also holds things such as sensors.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class RobotMap
{
    // Drivetrain controllers
    public static final TalonSRX frontLeftController = new TalonSRX(2);
    public static final TalonSRX frontRightController = new TalonSRX(1);
    public static final VictorSPX backLeftController = new VictorSPX(0);
    public static final VictorSPX backRightController = new VictorSPX(1);


    // Block Intake controllers
    public static final Spark leftIntakeController = new Spark(0);
    public static final Spark rightIntakeController = new Spark(1);

    public static final Solenoid leftIntakePiston = new Solenoid(0);
    public static final Solenoid rightIntakePiston = new Solenoid(1);


    //Flipper Controller
    public static final TalonSRX flipController = new TalonSRX(0);


    //Winch Controller
    public static final Spark winchController = new Spark(4);

    public static final I2C blockSense = new I2C(I2C.Port.kOnboard, 0x29);


    // NavX
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
}
