package frc.team6817.robot.Commands.Drivetrain;


import edu.wpi.first.wpilibj.command.PIDCommand;

public class DriveToDistance extends PIDCommand
{
    private double _distance;

    /**
     * Initializes standard PID variables
     */
    public DriveToDistance(final double DISTANCE)
    {
        super(2.0 , 0.0 , 0.0);

        _distance = DISTANCE;
    }


    @Override
    protected double returnPIDInput()
    {
        return 0;
    }


    @Override
    protected void usePIDOutput(double output)
    {

    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
