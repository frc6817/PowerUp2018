package frc.team6817.robot.Subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team6817.robot.Commands.BlockIntake.ManualBlockIntake;

import static frc.team6817.robot.RobotMap.leftIntakeController;
import static frc.team6817.robot.RobotMap.rightIntakeController;


public class BlockIntake extends Subsystem
{
    /**
     * Default command of the intake wheels- right trigger spins the wheels inward, left trigger spins the wheels
     * outward. When neither one is pressed, the intake wheels do not move. In the event that both are pressed,
     * intake holds priority.
     *
     * Bumpers control arm actuation. The right bumper shuts off both pistons and brings the arms inward.
     * The left bumper turns on both pistons and pushes the arms outward. Note that actuation of the arms stops the
     * intake wheels. Also note that if the arms are retracted inward, the flipper will not move.
     */
    @Override
    protected void initDefaultCommand()

    {
        setDefaultCommand(new ManualBlockIntake());
    }


    /**
     * Stops the motors. Does not affect the pistons, as they only have two positions/states and further actuation
     * after a stop call can be dangerous to those around the robot.
     */
    public void stop()
    {
        leftIntakeController.stopMotor();
        rightIntakeController.stopMotor();
    }
}
