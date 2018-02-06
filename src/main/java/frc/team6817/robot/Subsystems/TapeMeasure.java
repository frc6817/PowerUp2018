package frc.team6817.robot.Subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import static frc.team6817.robot.RobotMap.tapeController;

public class TapeMeasure extends Subsystem
{
    private SpeedControllerGroup _tapeController = new SpeedControllerGroup(tapeController);


    private static final double WINDPOWER = 1.0;
    private static final double UNWINDPOWER = -1.0;

    @Override
    protected void initDefaultCommand()
    {
        // Nothing :)
    }

    /**
     * States of the tape measure
     *
     * UNWIND ,
     * WIND,
     * STOP
     */

    public enum State
    {
        UNWIND ,
        WIND ,
        STOP
    }
    /**
     * Sets how the flipper runs
     *
     * @param STATE State to set the intake to
     */

    public void setState(final State STATE)
    {
        switch(STATE)
        {
            case UNWIND:
                _tapeController.set(UNWINDPOWER);
                break;
            case WIND:
                _tapeController.set(WINDPOWER);
                break;
            case STOP:
                stop();
                break;
        }
    }
    /**
     * Stops the motors
     */
    private void stop()
    {
        _tapeController.stopMotor();
    }

}
