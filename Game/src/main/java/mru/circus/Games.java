/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.renderer.Camera;
import com.simsilica.es.EntityData;
import com.simsilica.es.base.DefaultEntityData;
import com.simsilica.state.GameSystemsState;
import java.util.logging.Level;
import java.util.logging.Logger;
import mru.circus.entity.ModelSystem;
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
    public static GameSystemsState startSystems(SimpleApplication app){
        LOG.log(Level.FINE, "Starting game systems");
        //init gss
        GameSystemsState gss = new GameSystemsState(false);
        //Simple application
        gss.register(AssetManager.class, app.getAssetManager());
        gss.register(Camera.class, app.getCamera());
        gss.register(Scene.class, new Scene(app.getRootNode(), app.getGuiNode()));
        //Entity
        EntityData data = new DefaultEntityData();
        gss.register(EntityData.class, data);
        //physics systems
        PhysicsSystem ps = new PhysicsSystem();
        gss.register(PhysicsSystem.class, ps);
        //Visual
        gss.addSystem(new ModelSystem());
        //finish
//        app.getStateManager().attach(gss);
        return gss;
    }
}
