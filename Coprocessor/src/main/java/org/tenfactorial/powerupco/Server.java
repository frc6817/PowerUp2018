package org.tenfactorial.powerupco;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * Server for communication over ethernet- this runs on the coprocessor
 *
 * @Todo Figure out compilation to coprocessor (Raspberry Pi, etc)
 */
@SuppressWarnings("FieldCanBeLocal")
public class Server extends Thread
{
    private DatagramSocket _socket;
    private boolean _running = false;
    private byte[] _wrapper = new byte[256];


    /**
     * Creates a server- if the socket cannot be created, then an error message is sent to std out and the console
     */
    Server()
    {
        try
        {
            _socket = new DatagramSocket(6817);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }


    /**
     * Runs the server- it forever waits for a packet from the client. After receiving the packet, the request is
     * processed and the data is sent back. Should any part of the process fail, then an error message is displayed
     * to the console.
     */
    @Override
    public void run()
    {
        _running = true;

        while (_running)
        {
            DatagramPacket packet = new DatagramPacket(_wrapper, _wrapper.length);

            try
            {
                _socket.receive(packet);
                System.out.println("Received a transmission!");
                System.out.println("It reads: " + new String(packet.getData() , 0 , packet.getLength()));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(_wrapper, _wrapper.length, address, port);
            String received = new String(packet.getData(), 0, packet.getLength());

            if (received.equals("end"))
            {
                _running = false;
                continue;
            }

            try
            {
                _socket.send(packet);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        _socket.close();
    }
}
