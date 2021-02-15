/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.test;

import com.jme3.app.SimpleApplication;
import com.simsilica.es.EntityData;
import com.simsilica.es.EntityId;
import com.simsilica.state.GameSystemsState;
import java.util.logging.Level;
import java.util.logging.Logger;
import mru.circus.Games;
import mru.circus.entity.EntityFactory;
import mru.circus.entity.NameData;
import mru.circus.entity.NameSystem;
import mru.circus.entity.PositionData;
import org.dyn4j.geometry.Vector2;

/**
 *
 * @author Matt
 */
public class GSSTest extends SimpleApplication{
    private static Logger BASELOG = Logger.getLogger(GSSTest.class.getPackageName());
    private int numNames = 0;
    private GameSystemsState gss;
    
    public static void main(String[] args) {
        //logging
        BASELOG.setLevel(Level.FINER);
        //app
        GSSTest app = new GSSTest();
        app.start();
    }
    
    @Override
    public void simpleInitApp() {
        System.out.println("Starting GSSTest");
        gss = Games.startSystems(this);
        EntityData data = gss.get(EntityData.class);
        EntityId playerId = EntityFactory.createTestPlayer(data, "Player", new Vector2(0,0));
        stateManager.attach(gss);
    }

    @Override
    public void simpleUpdate(float tpf) {
    }
}
