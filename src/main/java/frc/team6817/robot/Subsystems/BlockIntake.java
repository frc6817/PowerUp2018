package frc.team6817.robot.Subsystems;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.OI;

import static frc.team6817.robot.RobotMap.lIntakeController;
import static frc.team6817.robot.RobotMap.rIntakeController;


public class BlockIntake extends Subsystem
{
    private SpeedControllerGroup _leftController = new SpeedControllerGroup(lIntakeController);
    private SpeedControllerGroup _rightController = new SpeedControllerGroup(rIntakeController);

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
     * Default command of the intake wheels- right bumper spins the wheels inward, left bumper spins the wheels
     * outward. When neither button is pressed, the intake wheels do not move. In the event that both are pressed,
     * intake holds priority
     */
    @Override
    protected void initDefaultCommand()
    {
        if(OI.controller2().getBumper(GenericHID.Hand.kRight))
        {
            setState(BlockIntake.State.IN);
        }
        else if(OI.controller2().getBumper(GenericHID.Hand.kLeft))
        {
            setState(BlockIntake.State.IN);
        }
        else
        {
            setState(BlockIntake.State.STOP);
        }
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
                break;

            case OUT:
                _leftController.set(fullRevPower);
                _rightController.set(fullRevPower);
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
