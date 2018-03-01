package frc.team6817.robot.DashServer;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess"})
public class DashServer extends Thread
{
    public static final String MSG_END = "`";
    public static final String TAG_END = "|";

    private ServerSocket _serverSocket;

    private ArrayList<String> _messageList = new ArrayList<>();

    private Socket _server;
    private DataOutputStream _outStream;


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
        String inputData;
        StringBuilder finalMessage = new StringBuilder();

        if(_serverSocket.isClosed())
        {
            try
            {
                _server = _serverSocket.accept();
                SmartDashboard.putString("Socket" , "Accept");
                _outStream = new DataOutputStream(_server.getOutputStream());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


        try
        {
            //noinspection InfiniteLoopStatement
            for(;;)
            {
                inputData = new DataInputStream(_server.getInputStream()).readUTF();

                Parser.parseData(inputData);

                SmartDashboard.putString("Input" , "Got it");

                for (String i : _messageList)
                {
                    finalMessage.append(i);
                }
                _messageList.clear();

                _outStream.writeUTF(finalMessage.toString());

                SmartDashboard.putString("Sending this data" , finalMessage.toString());

                finalMessage = new StringBuilder();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    public void sendMessage(final String tag , final String message)
    {
        _messageList.add(tag + TAG_END + message + MSG_END);
    }
}
