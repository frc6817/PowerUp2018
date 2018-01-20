package frc.team6817.robot;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TableServer
{
    private static NetworkTable table;


    public TableServer()
    {
        table = table.getSubTable("datatable");
    }


    public static void testRun()
    {
        for(int i = 0; ; i ++)
        {
            table.getEntry("x").setNumber(i);

            try
            {
                Thread.sleep(250);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }

            SmartDashboard.putNumber("NetworkTables Test" , table.getEntry("y").getDouble(0));
        }
    }
}
