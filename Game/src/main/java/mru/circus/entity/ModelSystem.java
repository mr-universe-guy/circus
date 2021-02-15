/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.entity;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.simsilica.es.Entity;
import com.simsilica.es.EntityContainer;
import com.simsilica.es.EntityData;
import com.simsilica.sim.AbstractGameSystem;
import com.simsilica.sim.SimTime;
import mru.circus.Scene;
import org.dyn4j.geometry.Vector2;

/**
 * Load model assets and display them in the scene
 * @author Matt
 */
public class ModelSystem extends AbstractGameSystem{
    private final Node modelNode = new Node("Models");
    private ModelContainer models;
    private AssetManager assets;
    private EntityData data;
    private Material debugMat;

    @Override
    protected void initialize() {
        System.out.println("Model System Init");
        assets = getSystem(AssetManager.class);
        debugMat = new Material(assets, "Common/MatDefs/Misc/Unshaded.j3md");
        getSystem(Scene.class).getRootNode().attachChild(modelNode);
        data = getSystem(EntityData.class);
        models = new ModelContainer(data);
        models.start();
    }

    @Override
    protected void terminate() {
        modelNode.removeFromParent();
        models.stop();
    }

    @Override
    public void update(SimTime time) {
        models.update();
    }
    
    private class ModelContainer extends EntityContainer<Spatial>{

        public ModelContainer(EntityData ed) {
            super(ed, PositionData.class, ModelData.class);
        }
        

        @Override
        protected Spatial addObject(Entity e) {
            Vector2 pos = e.get(PositionData.class).getPosition();
            String modelAsset = e.get(ModelData.class).getAsset();
            Spatial model;
            if(modelAsset.equals(ModelData.DEBUG_CUBE)){
                Geometry geo = new Geometry(modelAsset, new Box(0.5f,0.5f,0.5f));
                geo.setMaterial(debugMat);
                model = geo;
            } else{
                model = assets.loadModel(modelAsset);
            }
            model.setLocalTranslation((float)pos.x, 0, (float)pos.y);
            modelNode.attachChild(model);
            System.out.println("Model created "+modelAsset);
            return model;
        }

        @Override
        protected void updateObject(Spatial model, Entity e) {
            Vector2 pos = e.get(PositionData.class).getPosition();
            model.setLocalTranslation((float)pos.x, 0, (float)pos.y);
        }

        @Override
        protected void removeObject(Spatial model, Entity e) {
            model.removeFromParent();
        }
    }
}
