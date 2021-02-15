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
public class PositionData implements EntityComponent{
    private Vector2 position;

    public PositionData(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }
}
