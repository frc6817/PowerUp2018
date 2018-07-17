package frc.team6817.robot.Commands.BlockIntake;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team6817.robot.OI;

import static frc.team6817.robot.Robot.blockIntake;
import static frc.team6817.robot.RobotMap.*;


public class ManualBlockIntake extends Command
{
    public static double INTAKE_THROTTLE = .5;
    public static double PIVOT_MULT = .5;


    public ManualBlockIntake()
    {
        super();

        requires(blockIntake);

        flip2.follow(flip1);
    }


    @Override
    public void execute()
    {
        if(OI.controller2().getBumperPressed(GenericHID.Hand.kRight))
        {
            intakeArms.set(DoubleSolenoid.Value.kForward);
        }
        else if(OI.controller2().getBumperPressed(GenericHID.Hand.kLeft))
        {
            intakeArms.set(DoubleSolenoid.Value.kReverse);
        }

        flip1.set(ControlMode.PercentOutput , OI.controller2().getY(GenericHID.Hand.kRight) * PIVOT_MULT);
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
        return false;
    }
}
