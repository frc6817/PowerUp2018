package frc.team6817.robot.Subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import static frc.team6817.robot.RobotMap.*;

public class Lift extends Subsystem {
    private SpeedControllerGroup _liftLgroup =  new SpeedControllerGroup(liftController1,liftController3);
    private SpeedControllerGroup _liftRgroup = new SpeedControllerGroup(liftController2,liftController4);

    public enum State
    {
        UP ,
        DOWN ,
        STOP
    }

    /**
     * Default command of the Lift
     */
    @Override
    protected void initDefaultCommand()
    {
        // Nothing :)
    }


    /**
     * Sets how the Lift works
     *
     * @param STATE State to set the Lift to thingies
     */
    public void setState(final State STATE, final double Speed)
    {
        switch(STATE)
        {
            case UP:
                _liftLgroup.set(Speed);
                _liftRgroup.set(Speed);
                break;

            case DOWN:
                _liftLgroup.set(-Speed);
                _liftRgroup.set(-Speed);
                break;

            case STOP:
                stop();
                break;
        }
    }
    /**
     * Stops the Lift motors
     */
    public void stop()
    {
        _liftLgroup.stopMotor();
        _liftRgroup.stopMotor();
    }

}
