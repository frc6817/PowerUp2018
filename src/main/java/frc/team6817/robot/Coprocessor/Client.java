package frc.team6817.robot.Coprocessor;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * Class that manages communication with the coprocessor
 *
 * @Todo Add OpenCV library, test with another ethernet device
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class Client
{
    private final String _SERVER_NAME = "Compootis";
    private final int _PORT = 6817;
    private InetAddress _address;
    private DatagramPacket _packet;
    private DatagramSocket _socket;


    /**
     * Data request modes that are given to the server to determine what kind of data the server should respond with.
     *
     * SNAPSHOT1:   Picture of current view from camera 1
     * SNAPSHOT2:   Picture of current view from camera 2
     * STREAM1:     Live video stream from camera 1
     * STREAM2:     Live video stream from camera 2
     * DATA:        Data crunched from vision analysis
     * STOP:        Stops all camera functions
     *
     * @Todo Figure out actual data packet size
     */
    enum RequestCode
    {
        // There are temporary numbers to prevent the compiler from screaming- change these!
        SNAPSHOT1((byte)0 , 256) ,
        SNAPSHOT2((byte)1 , 256) ,
        STREAM1((byte)2 , 256) ,
        STREAM2((byte)3 , 256) ,
        DATA((byte)4 , 128) ,
        STOP((byte)5 , 1);

        private byte[] _code = new byte[1];
        private int _dataSize;


        /**
         * Creates a code for each enumeration
         *
         * @param CODE Code to assign to the enumeration
         */
        RequestCode(final byte CODE , final int DATA_SIZE)
        {
            _code[0] = CODE;
            _dataSize = DATA_SIZE;
        }


        /**
         * @return The code of the request
         */
        public byte[] code()
        {
            return _code;
        }


        /**
         * @return Returns expected returned data size of the request
         */
        public int dataSize()
        {
            return _dataSize;
        }
    }


    /**
     * Makes a request to the server, stores returned data appropriately.
     *
     * @param REQUEST Request to make to the server
     *
     * @return True if operation was successful- false otherwise
     *
     * @Todo Receiving data
     */
    boolean request(RequestCode REQUEST)
    {
        // Sending
        try
        {
            _socket = new DatagramSocket();
            _address = InetAddress.getByName(_SERVER_NAME);
            _packet = new DatagramPacket(REQUEST.code() , 1 , _address , _PORT);
            _socket.send(_packet);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }

        // Receiving

        return true;
    }
}
