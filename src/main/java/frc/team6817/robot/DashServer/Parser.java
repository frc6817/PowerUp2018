package frc.team6817.robot.DashServer;


import frc.team6817.robot.Commands.BlockIntake.ManualBlockIntake;
import frc.team6817.robot.Commands.Drivetrain.PrecisionDrive;
import frc.team6817.robot.Commands.Drivetrain.RotateToDegree;
import frc.team6817.robot.Commands.Drivetrain.StandardDrive;


/**
 * Parses the messages received from the DashServer and then notifies the appropriate classes of changes in data.
 */
@SuppressWarnings("WeakerAccess")
class Parser
{
    /**
     * Parses the messages received from the DashServer and then notifies the appropriate classes of changes in data.
     *
     * @param data Message list received from the DashServer
     */
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
                case "Delay":
                    break;

                case "Pos":
                    switch(msg)
                    {
                        case "Left":
                            break;

                        case "Center":
                            break;

                        case "Right":
                            break;

                        default:
                            // Nothing
                            break;
                    }

                    break;

                case "Drive":
                    StandardDrive.THROTTLE = Double.valueOf(msg) / 100.0;
                    break;

                case "PDrive":
                    PrecisionDrive.DRIVE_MULTIPLIER = Double.valueOf(msg) / 100.0;
                    break;

                case "Flip":
                    break;

                case "Fly":
                    ManualBlockIntake.INTAKE_THROTTLE = Double.valueOf(msg) / 100.0;
                    break;

                case "TurnP":
                    RotateToDegree.P = Double.valueOf(msg);
                    break;

                case "TurnI":
                    RotateToDegree.I = Double.valueOf(msg);
                    break;

                case "TurnD":
                    RotateToDegree.D = Double.valueOf(msg);

                default:
                  // Nothing- discard message
                    break;
            }
        }
    }
}
