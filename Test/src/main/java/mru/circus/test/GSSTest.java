/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.test;

import com.jme3.app.SimpleApplication;
import com.simsilica.state.GameSystemsState;
import java.util.logging.Level;
import java.util.logging.Logger;
import mru.circus.Games;

/**
 *
 * @author Matt
 */
public class GSSTest extends SimpleApplication{
    private static Logger BASELOG = Logger.getLogger(GSSTest.class.getPackageName());
    
    public static void main(String[] args) {
        //logging
        BASELOG.setLevel(Level.FINER);
        //app
        GSSTest app = new GSSTest();
        app.start();
    }
    
    @Override
    public void simpleInitApp() {
        GameSystemsState gss = Games.startSystems();
        stateManager.attach(gss);
    }
}
