/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.physics;

import com.simsilica.es.EntityData;
import com.simsilica.sim.AbstractGameSystem;
import com.simsilica.sim.SimTime;
import org.dyn4j.dynamics.PhysicsBody;
import org.dyn4j.world.World;
import org.dyn4j.world.listener.StepListener;

/**
 *
 * @author Matt
 */
public class PhysicsSystem extends AbstractGameSystem{
    private final World physWorld = new World();
    private final double timeStep = 1.0/60;
    private EntityData data;

    @Override
    protected void initialize() {
        System.out.println("Hello Physics");
        physWorld.getSettings().setStepFrequency(timeStep);
        data = getManager().get(EntityData.class);
    }

    @Override
    protected void terminate() {
        
    }

    @Override
    public void update(SimTime time) {
        physWorld.update(time.getTpf());
    }
    
    public <T extends PhysicsBody> void addStepListener(StepListener<T> l){
        physWorld.addStepListener(l);
    }
    
    public <T extends PhysicsBody> boolean removeStepListener(StepListener<T> l){
        return physWorld.removeStepListener(l);
    }
}
