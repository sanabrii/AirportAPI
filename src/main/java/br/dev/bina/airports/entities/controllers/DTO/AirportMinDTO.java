/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.bina.airports.entities.controllers.DTO;

import br.dev.bina.airports.entities.Airport;

/**
 *
 * @author sesidevb
 */
public class AirportMinDTO {
    
    private long id; 
    private String name; 
    private String city; 
    private String iataCode;
    
    public AirportMinDTO() {
    }

    public AirportMinDTO(Airport airport) {
        this.id = airport.getId();
        this.name = airport.getName(); 
        this.city = airport.getCity();
        this.iataCode = airport.getIataCode();
}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getIataCode() {
        return iataCode;
    }

    public AirportMinDTO(long id, String name, String city, String iataCode) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.iataCode = iataCode;
    }
    
    
}
