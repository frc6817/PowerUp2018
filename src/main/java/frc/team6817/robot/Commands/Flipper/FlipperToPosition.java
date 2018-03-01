package frc.team6817.robot.Commands.Flipper;


import edu.wpi.first.wpilibj.command.Command;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.Robot.flipper;
import static frc.team6817.robot.RobotMap.flipController;
import static frc.team6817.robot.Subsystems.Flipper.COUNTS_PER_DEGREE;


public class FlipperToPosition extends Command
{
    public enum Position
    {
        BOTTOM(0) ,
        TOP((int)(160 * COUNTS_PER_DEGREE));

        private int _encoderCount;


        Position(final int ENCODER_COUNT)
        {
            _encoderCount = ENCODER_COUNT;
        }


        public int count()
        {
            return _encoderCount;
        }
    }


    public FlipperToPosition(final Position POSITION)
    {
        requires(blockIntake);
        requires(flipper);

        flipper.setSetpoint(POSITION.count());
    }


    @Override
    protected boolean isFinished()
    {
        return Math.abs(flipController.getSensorCollection().getQuadraturePosition() - flipper.getSetpoint()) <= 2 * COUNTS_PER_DEGREE;
    }
}
