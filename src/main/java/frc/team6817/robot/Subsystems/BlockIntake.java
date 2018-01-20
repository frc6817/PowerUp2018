package frc.team6817.robot.Subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import static frc.team6817.robot.RobotMap.lIntakeController;
import static frc.team6817.robot.RobotMap.mIntakeController;
import static frc.team6817.robot.RobotMap.rIntakeController;


public class BlockIntake extends Subsystem
{
    private SpeedControllerGroup _leftController = new SpeedControllerGroup(lIntakeController);
    private SpeedControllerGroup _rightController = new SpeedControllerGroup(rIntakeController);
    private SpeedControllerGroup _midController = new SpeedControllerGroup(mIntakeController);

    private static final double fullPower = 1.0;
    private static final double fullRevPower = -1.0;

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
                _leftController.set(fullPower);
                _rightController.set(fullPower);
                _midController.set(fullPower);
                break;

            case OUT:
                _leftController.set(fullRevPower);
                _rightController.set(fullRevPower);
                _midController.set(fullRevPower);
                break;

            case STOP:
                stop();
                break;
        }
    }


    /**
     * Stops the motors
     */
    public void stop()
    {
        _leftController.stopMotor();
        _rightController.stopMotor();
        _midController.stopMotor();
    }
}
