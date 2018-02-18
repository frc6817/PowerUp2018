package frc.team6817.robot.Subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import static frc.team6817.robot.RobotMap.*;
public class Flip extends Subsystem
{
    private SpeedControllerGroup _flipController = new SpeedControllerGroup(flipController1);


    private static final double FLIPPOWER = 1.0;
    private static final double UNFLIPPOWER = -1.0;

    @Override
    protected void initDefaultCommand()
    {
        // Nothing :)
    }

    /**
     * States of the flipper
     *
     * UNFLIP ,
     * FLIP,
     * STOP
     */

    public enum State
    {
        UNFLIPENC ,
        FLIPENC ,
        FLIP,
        UNFLIP,
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
            case UNFLIP:
                _flipController.set(UNFLIPPOWER);
                break;
            case FLIP:
                _flipController.set(FLIPPOWER);
                break;
            case FLIPENC:

                break;
            case UNFLIPENC:
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
        _flipController.stopMotor();
    }


}
