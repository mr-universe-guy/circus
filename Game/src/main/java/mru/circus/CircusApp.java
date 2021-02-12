/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus;

import com.jme3.app.SimpleApplication;
import java.util.logging.Logger;

/**
 *
 * @author Matt
 */
public class CircusApp extends SimpleApplication{
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircusApp app = new CircusApp();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        System.out.println("Hello World");
    }
}
