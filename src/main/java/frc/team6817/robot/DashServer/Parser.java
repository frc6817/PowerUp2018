package frc.team6817.robot.DashServer;


import frc.team6817.robot.Autonomous.AutoLeft;
import frc.team6817.robot.Commands.Drivetrain.PrecisionDrive;
import frc.team6817.robot.Robot;


@SuppressWarnings("WeakerAccess")
public class Parser
{
    public static void parseData(String data)
    {
        String individualMsg;

        while(data.length() > 0)
        {
            String tag;
            String msg;

            individualMsg = data.substring(0 , data.indexOf(DashServer.MSG_END));
            data = data.substring(data.indexOf(DashServer.MSG_END) + 1);

            tag = individualMsg.substring(0 , individualMsg.indexOf(DashServer.TAG_END));
            msg = individualMsg.substring(individualMsg.indexOf(DashServer.TAG_END) + 1);

            switch(tag)
            {
                case "StartPos":
                    switch(msg)
                    {
                        case "left":
                            Robot.auto = new AutoLeft();
                            break;

                        case "center":
                            break;

                        case "right":
                            break;

                        default:
                            // Nothing
                            break;
                    }

                    break;

                case "PercentPrecision":
                    PrecisionDrive.DRIVE_MULTIPLIER = Double.valueOf(msg);
                    break;

                case "StartDelay":

                    break;

                default:
                    // Nothing- discard message
                    break;
            }
        }
    }
}
