/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import mundo.SocketServer;

public class Controlador {

    SocketServer socketServer;

    public Controlador() {
        socketServer = new SocketServer("localhost", 5050, 5000, this);
     
    }

    public  void conectar() {
        Thread hilo = new Thread(socketServer);
        hilo.start();
    }

    public void toReceive(String msg) {
        System.out.println(msg);
        socketServer.enviar("Welcome to the Server...");
    }

}
