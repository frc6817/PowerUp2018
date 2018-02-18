package frc.team6817.robot.Commands.Drivetrain;


import edu.wpi.first.wpilibj.command.PIDCommand;

public class DriveToDistance extends PIDCommand
{
    private final double COUNTS_PER_INCH = 2770.57;

    private double _distance;           // This is the distance in ENCODER COUNTS


    /**
     * Initializes standard PID variables
     */
    public DriveToDistance(final double DISTANCE)
    {
        super(2.0 , 0.0 , 0.0);

        _distance = DISTANCE * COUNTS_PER_INCH;
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
