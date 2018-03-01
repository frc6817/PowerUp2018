package frc.team6817.robot;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TableServer extends Thread
{
    private static NetworkTable _table;
    private static NetworkTableInstance table;


    public static void init()
    {
        NetworkTableInstance instance = NetworkTableInstance.getDefault();
        instance.setServer("10.68.17.2");
        instance.startServer();

        _table = instance.getTable("datatable");
    }


    @Override
    public void run()
    {
        for(int i = 0; i < 1_000; i ++)
        {
            _table.getEntry("x").setNumber(i);

            try
            {
                Thread.sleep(250);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }

            SmartDashboard.putNumber("NetworkTables Test Y" , _table.getEntry("y").getDouble(0));
            SmartDashboard.putNumber("NetworkTables Test X" , _table.getEntry("x").getDouble(0));
        }
    }

//    edu.wpi.first.wpilibj.networktables.NetworkTable

    public static void testRun()
    {
        for(int i = 0; i < 1_000; i ++)
        {
            _table.getEntry("x").setNumber(i);

//            try
//            {
//                Thread.sleep(250);
//            }
//            catch(InterruptedException e)
//            {
//                e.printStackTrace();
//            }

            SmartDashboard.putNumber("NetworkTables Test Y" , _table.getEntry("y").getDouble(0));
            SmartDashboard.putNumber("NetworkTables Test X" , _table.getEntry("x").getDouble(0));
        }
    }
}
