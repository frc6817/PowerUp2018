package frc.team6817.robot;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;



/**
 * For mapping sensors and actuator ports to a variable name
 */
@SuppressWarnings("unused")
public class RobotMap
{
    // Drivetrain controllers
    public static final TalonSRX frontLeftController = new TalonSRX(0);
    public static final TalonSRX frontRightController = new TalonSRX(1);
    public static final VictorSP backLeftController = new VictorSP(0);
    public static final VictorSP backRightController = new VictorSP(1);


    // Block Intake controllers
    public static final Spark lIntakeController = new Spark(2);
    public static final Spark rIntakeController = new Spark(3);


    //Flipper Controller
    public static final TalonSRX flipController = new TalonSRX(3);


    //Winch Controller
    public static final Spark winchController = new Spark(4);


    // NavX
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
}
