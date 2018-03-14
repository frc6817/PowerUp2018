package frc.team6817.robot.DashServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 * Dashboard server- sends and receives data to and from QDash, our dashboard. This code is non-blocking.
 */
@SuppressWarnings({"FieldCanBeLocal", "WeakerAccess"})
public class DashServer extends Thread
{
    public static final String MSG_END = "`";
    public static final String TAG_END = "|";

    private static final int TICKRATE = 100;    // Server tickrate in milliseconds


    private ServerSocket _serverSocket;
    private Socket _server;

    private PrintWriter _out = null;
    private BufferedReader _in = null;

    private ArrayList<String> _messageList = new ArrayList<>(); // Messages to send to the Dashboard


    /**
     * Attempt to start running the dash server on the specified port. Stacktrace error message if failed.
     *
     * @param PORT Port number this server runs on
     */
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


    /**
     * Runs the server- periodically, it first sends and then receives a message. It continues to do this so long
     * as the connection between this and QDash is okay. Should the connection break or not exist, then this will
     * continue to try to connect to QDash.
     */
    @Override
    public void run()
    {
        // Double infinite loops are intentional.
        //noinspection InfiniteLoopStatement
        for(;;)
        {
            try
            {
                establishConnection();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            for(;;)
            {
                try
                {
                    if(_server.isConnected())
                    {
                        StringBuilder finalMessage = new StringBuilder();

                        for(int i = 0; i < _messageList.size(); i ++)
                        {
                            finalMessage.append(i);
                        }

                        _out.write(finalMessage.toString());
                        _out.flush();

                        // Reading blocks, but it is okay- send and receive should alternate on both programs.
                        Parser.parseData(_in.readLine());
                    }
                    Thread.sleep(TICKRATE);
                }
                catch(Exception e)
                {
                    break;
                }
            }
        }
    }


    /**
     * Attempts to establish a connection with QDash client. Outputs stacktrace error message on fail.
     *
     * @throws IOException Thrown upon connection failure.
     */
    private void establishConnection() throws IOException
    {
        _server = _serverSocket.accept();
        _in =  new BufferedReader(new InputStreamReader(_server.getInputStream()));
        _out = new PrintWriter(_server.getOutputStream());
    }


    /**
     * Doesn't actually send the message- adds the message to a queue to be sent.
     *
     * @param tag Message tag- this is important information such as identity and purpose
     * @param message Actual message data. These would be the numbers and values and so forth
     */
    public void sendMessage(final String tag , final String message)
    {
        _messageList.add(tag + TAG_END + message + MSG_END);
    }
}
