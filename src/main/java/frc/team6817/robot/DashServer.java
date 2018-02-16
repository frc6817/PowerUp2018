package frc.team6817.robot;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DashServer extends Thread
{
    private ServerSocket _serverSocket;


    public DashServer(final int PORT)
    {
        try
        {
            _serverSocket = new ServerSocket(PORT);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void run()
    {
        String inputData = "";

        DataOutputStream outStream;


        try
        {
            Socket server = _serverSocket.accept();

            inputData = new DataInputStream(server.getInputStream()).readUTF();

            outStream = new DataOutputStream(server.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        //noinspection InfiniteLoopStatement
        for(;;)
        {
            // Send string of data fam
        }
    }
}
