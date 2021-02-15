/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mru.circus.entity;

import com.simsilica.es.EntityComponent;

/**
 * An entities name
 * @author Matt
 */
public class NameData implements EntityComponent{
    private String name;

    public NameData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
