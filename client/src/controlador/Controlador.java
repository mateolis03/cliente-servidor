package controlador;

import mundo.socketClient;

public class Controlador {

    socketClient socketClient;

    public Controlador() {
        socketClient = new socketClient("localhost", 5000, 5050, this);

    }

    public void conectar() {
        Thread hilo = new Thread(socketClient);
        socketClient.enviar("Hello World!!!");
        hilo.start();
    }

    public void toReceive(String msg) {
        System.out.println(msg);

    }

}
