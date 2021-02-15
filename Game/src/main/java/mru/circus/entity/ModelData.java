/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.entity;

import com.simsilica.es.EntityComponent;

/**
 *
 * @author Matt
 */
public class ModelData implements EntityComponent{
    public static final String DEBUG_CUBE = "Cube";
    
    private String asset;

    public ModelData(String asset) {
        this.asset = asset;
    }

    public String getAsset() {
        return asset;
    }
}
