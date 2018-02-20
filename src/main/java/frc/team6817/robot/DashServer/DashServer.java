package frc.team6817.robot.DashServer;


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

        DataOutputStream outStream;


        try
        {
            Socket server = _serverSocket.accept();
            inputData = new DataInputStream(server.getInputStream()).readUTF();
            outStream = new DataOutputStream(server.getOutputStream());

            String finalMessage = "";

            //noinspection InfiniteLoopStatement
            for(;;)
            {
                Parser.parseData(inputData);

                for(String i: _messageList)
                {
                    finalMessage += i;
                }
                _messageList.clear();
                outStream.writeUTF(finalMessage);

                Thread.sleep(200);
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
