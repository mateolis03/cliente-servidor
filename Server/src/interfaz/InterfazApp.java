/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controlador.Controlador;

/**
 *
 * @author mateo
 */
public class InterfazApp {


    public InterfazApp(Controlador ctrl) {
        System.out.println("Server");
        ctrl.conectar();
    }

    public static void main(String[] args) {
        new InterfazApp(new Controlador());

    }

}
