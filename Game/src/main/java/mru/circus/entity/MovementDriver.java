/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.entity;

import com.simsilica.es.EntityComponent;
import org.dyn4j.geometry.Vector2;

/**
 *
 * @author Matt
 */
public class MovementDriver implements EntityComponent{
    private Vector2 direction;

    /**
     * @param direction A vector who's length is between 0 and 1
     */
    public MovementDriver(Vector2 direction) {
        this.direction = direction;
    }

    public Vector2 getDirection() {
        return direction;
    }
}
