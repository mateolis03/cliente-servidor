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
public class interfazApp {


    public interfazApp(Controlador ctrl) {
        System.out.println("Cliente");
        ctrl.conectar();
    }

    public static void main(String[] args) {
        new interfazApp(new Controlador());

    }

}
