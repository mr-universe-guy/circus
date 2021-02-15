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
public class FlightData implements EntityComponent{
    private double flightSpeed;

    public FlightData(double flightSpeed) {
        this.flightSpeed = flightSpeed;
    }

    public double getFlightSpeed() {
        return flightSpeed;
    }
}
