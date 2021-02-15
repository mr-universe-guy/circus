/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.entity;

import com.simsilica.es.EntityData;
import com.simsilica.es.EntityId;
import org.dyn4j.geometry.Vector2;

/**
 *
 * @author Matt
 */
public class EntityFactory {
    public static EntityId createTestPlayer(EntityData data, String name, Vector2 pos){
        EntityId id = data.createEntity();
        data.setComponents(id,
                new PositionData(pos),
                new NameData(name),
                new ModelData(ModelData.DEBUG_CUBE)
        );
        return id;
    }
}
