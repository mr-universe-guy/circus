/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.entity;

import com.simsilica.es.Entity;
import com.simsilica.es.EntityContainer;
import com.simsilica.es.EntityData;
import com.simsilica.es.EntityId;
import com.simsilica.sim.AbstractGameSystem;
import mru.circus.physics.PhysicsSystem;
import org.dyn4j.dynamics.TimeStep;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.PhysicsWorld;
import org.dyn4j.world.listener.StepListenerAdapter;

/**
 *
 * @author Matt
 */
public class FlightSystem extends AbstractGameSystem{
    private StepListenerAdapter physStepper;
    private PhysicsSystem phys;
    private EntityData data;
    private FlightContainer flyers;

    @Override
    protected void initialize() {
        phys = getSystem(PhysicsSystem.class);
        physStepper = new StepListenerAdapter(){
            @Override
            public void begin(TimeStep step, PhysicsWorld world) {
                physUpdate(step,world);
            }
        };
        phys.addStepListener(physStepper);
        data = getSystem(EntityData.class);
        flyers = new FlightContainer(data);
        flyers.start();
    }

    @Override
    protected void terminate() {
        phys.removeStepListener(physStepper);
        flyers.stop();
    }
    
    protected void physUpdate(TimeStep step, PhysicsWorld world){
        flyers.update();
        flyers.stepPhysics(step);
    }
    
    private class FlightContainer extends EntityContainer<Flyer>{
        public FlightContainer(EntityData ed) {
            super(ed, PositionData.class, FlightData.class, MovementDriver.class);
        }

        @Override
        protected Flyer addObject(Entity e) {
            System.out.println("Flyer has been added "+e);
            Flyer fly = new Flyer();
            fly.speed = e.get(FlightData.class).getFlightSpeed();
            fly.dir = e.get(MovementDriver.class).getDirection();
            fly.pos = e.get(PositionData.class).getPosition();
            fly.id = e.getId();
            return fly;
        }

        @Override
        protected void updateObject(Flyer object, Entity e) {
            object.dir = e.get(MovementDriver.class).getDirection();
            object.pos = e.get(PositionData.class).getPosition();
        }

        @Override
        protected void removeObject(Flyer object, Entity e) {
            
        }
        
        public void stepPhysics(TimeStep step){
            System.out.println("Step flyers");
            Flyer[] flyers = getArray();
            double tpf = step.getDeltaTime();
            for(Flyer fly : flyers){
                Vector2 nextPos = fly.pos.sum(fly.dir.product(tpf*fly.speed));
                data.setComponent(fly.id, new PositionData(nextPos));
                System.out.println(nextPos);
            }
        }
    }
    
    private class Flyer{
        private EntityId id;
        private double speed;
        private Vector2 dir;
        private Vector2 pos;
    }
}
