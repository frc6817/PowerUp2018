package frc.team6817.robot.Subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import static frc.team6817.robot.RobotMap.lIntakeController;
import static frc.team6817.robot.RobotMap.rIntakeController;


public class BlockIntake extends Subsystem
{
    private SpeedControllerGroup _leftController = new SpeedControllerGroup(lIntakeController);
    private SpeedControllerGroup _rightController = new SpeedControllerGroup(rIntakeController);


    /**
     * States of the block intake
     *
     * IN ,
     * OUT ,
     * STOP
     */
    public enum State
    {
        IN ,
        OUT ,
        STOP
    }


    /**
     * Default command of the intake wheels
     */
    @Override
    protected void initDefaultCommand()
    {
        // Nothing :)
    }


    /**
     * Sets how the intake runs
     *
     * @param STATE State to set the intake to
     */
    public void setState(final State STATE)
    {
        switch(STATE)
        {
            case IN:
                _leftController.set(1.0);
                _rightController.set(1.0);
                break;

            case OUT:
                _leftController.set(-1.0);
                _rightController.set(-1.0);
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
        _leftController.stopMotor();
        _rightController.stopMotor();
    }
}
