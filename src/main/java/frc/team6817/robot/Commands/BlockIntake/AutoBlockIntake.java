package frc.team6817.robot.Commands.BlockIntake;

import edu.wpi.first.wpilibj.command.Command;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.RobotMap.leftIntakeController;
import static frc.team6817.robot.RobotMap.leftIntakePiston;
import static frc.team6817.robot.RobotMap.rightIntakeController;


public class AutoBlockIntake extends Command {
    private long _time;
    private final static double FLYPOWER = 1;
    private boolean _finished = false;


    /**
     * Creates a Drive For Time command, requires the blockIntake
     * <p>
     * Invokes superconstructor.
     *
     * @param LEFT_POWER  Power to set to the left side
     * @param RIGHT_POWER Power to set to the right side
     * @param TIME        Time to collect to in milliseconds
     */
    public AutoBlockIntake(final double LEFT_POWER, final double RIGHT_POWER, final long TIME) {
        super();

        requires(blockIntake);
        _time = TIME;
    }
    @Override
    public void execute()
    {
        long startTime = System.currentTimeMillis();

        while(System.currentTimeMillis() - startTime < _time)
        {
            leftIntakeController.set(-FLYPOWER);
            rightIntakeController.set(FLYPOWER);
        }

        _finished = true;
    }


    @Override
    public void interrupted()
    {
        blockIntake.stop();
    }


    @Override
    public void end()
    {
        blockIntake.stop();
    }


    @Override
    protected boolean isFinished()
    {
        return _finished;
    }
}

