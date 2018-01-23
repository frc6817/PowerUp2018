package frc.team6817.robot.Commands;


import edu.wpi.first.wpilibj.command.PIDCommand;


public class LiftToDistance extends PIDCommand {
    private double _distance;
    /**
     * Initializes standard PID variables
     */
    public LiftToDistance(final double DISTANCE)
    {
        super(0,0,0);
        _distance = DISTANCE;
    }

    @Override
    protected double returnPIDInput(){return 0;}

    @Override
    protected void usePIDOutput(double output){}

    @Override
    protected boolean isFinished(){return false;}

}
