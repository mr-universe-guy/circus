/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.entity;

import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.simsilica.es.Entity;
import com.simsilica.es.EntityData;
import com.simsilica.es.EntityId;
import com.simsilica.es.EntitySet;
import com.simsilica.sim.AbstractGameSystem;
import com.simsilica.sim.SimTime;
import java.util.HashMap;
import java.util.Map;
import mru.circus.Scene;
import org.dyn4j.geometry.Vector2;

/**
 * Displays a name at a position.
 * @author Matt
 */
public class NameSystem extends AbstractGameSystem{
    private Map<EntityId, BitmapText> nameMap = new HashMap<>(); 
    private EntityData data;
    private EntitySet names;
    private Node nameNode = new Node("Names");
    private BitmapFont font;

    @Override
    protected void initialize() {
        System.out.println("Name system initializing");
        data = getManager().get(EntityData.class);
        names = data.getEntities(NameData.class, PositionData.class);
        Node gui = getManager().get(Scene.class).getGuiNode();
        gui.attachChild(nameNode);
        font = getManager().get(AssetManager.class).loadFont("Interface/Fonts/Default.fnt");
    }

    @Override
    protected void terminate() {
        nameNode.removeFromParent();
        names.release();
    }

    @Override
    public void update(SimTime time) {
        if(names.applyChanges()){
            names.getRemovedEntities().forEach(n -> removeName(n));
            names.getAddedEntities().forEach(n -> addName(n));
            names.getChangedEntities().forEach(n -> updateName(n));
        }
    }

    private void addName(Entity n) {
        String name = n.get(NameData.class).getName();
        BitmapText text = font.createLabel(name);
        text.setColor(ColorRGBA.Blue);
        text.setSize(72);
        nameMap.put(n.getId(), text);
        Vector2 pos = n.get(PositionData.class).getPosition();
        text.setLocalTranslation((float)pos.x,(float)pos.y,0);
        nameNode.attachChild(text);
    }

    private void removeName(Entity n) {
        BitmapText text = nameMap.get(n.getId());
        if(text == null) return;
        text.removeFromParent();
    }

    private void updateName(Entity n) {
        BitmapText text = nameMap.get(n.getId());
        Vector2 pos = n.get(PositionData.class).getPosition();
        text.setLocalTranslation((float)pos.x, 0, (float)pos.y);
    }
}
