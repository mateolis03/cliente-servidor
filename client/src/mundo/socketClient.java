/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import controlador.Controlador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class socketClient implements Runnable {

    private String ip;
    private int portSend;
    private int portListen;
    private ServerSocket server;
    public Controlador ctrl;

    public socketClient(String ip, int portSend, int portListen, Controlador ctrl) {
        this.ip = ip;
        this.portSend = portSend;
        this.portListen = portListen;
        this.ctrl = ctrl;


    }

    public void enviar(String msg) {
        try {
            Socket client = new Socket(ip, this.portSend); // portSend 5000
            DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream());
            outBuffer.writeUTF(msg);
            client.close();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "socket() : UnknownHostException: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "socket() : IOException: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        Socket socket;
        ObjectInputStream inObjectBuffer;

        try {
            server = new ServerSocket(portListen);  // portListen 5000 

            while (true) {
                socket = server.accept();
                DataInputStream inDataBuffer = new DataInputStream(socket.getInputStream());
                ctrl.toReceive(inDataBuffer.readUTF());
                socket.close();
            }
        } catch (IOException e) { //ctrl.toException("run() : IOException: " + e.getMessage());  }
        }

    }
}
