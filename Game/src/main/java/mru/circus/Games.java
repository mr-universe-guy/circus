/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus;

import com.simsilica.state.GameSystemsState;
import java.util.logging.Level;
import java.util.logging.Logger;
import mru.circus.physics.PhysicsSystem;

/**
 * Simple helper for starting games
 * @author Matt
 */
public class Games {
    private static Logger LOG = Logger.getLogger(Games.class.getName());
    /**
     * Starts necessary game systems in a orderly fashion
     * @return 
     */
    public static final GameSystemsState startSystems(){
        LOG.log(Level.FINE, "Starting game systems");
        //init gss
        GameSystemsState gss = new GameSystemsState(false);
        //physics systems
        PhysicsSystem ps = new PhysicsSystem();
        gss.addSystem(ps);
        return gss;
    }
}
