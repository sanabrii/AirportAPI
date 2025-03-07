/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.bina.airports.repositories.service;

import br.dev.bina.airports.entities.Airport;
import br.dev.bina.airports.entities.controllers.DTO.AirportMinDTO;
import br.dev.bina.airports.entities.controllers.DTO.AirportNearMeDTO;
import br.dev.bina.airports.entities.projections.AirportNearMeProjection;
import br.dev.bina.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sesidevb
 */

@Service
public class AirportService {
    
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll() {
        
        List<Airport> result = airportRepository.findAll();
        return result;
        
    }
    
    /**
     * Retorna DTO Airports filtrado por cidade.
     * @param city
     * @return
     */
    public List<Airport> findByCity(String city) {
        List<Airport> result = airportRepository.findByCityIgnoreCase(city);
        return result;
}
    
    /**
     * Retorna DTO AirportsMinDTO filtrado por country (pais).
     * @param country
     * @return
     */
    public List<AirportMinDTO> findByCountry(String country) {
        List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);
        
        List<AirportMinDTO> resultDTO = resultAirport.stream() 
                .map(x -> new AirportMinDTO(x)).toList();
        
        return resultDTO;
}
    
    
    /**
     * Retorna DTO Airport por iataCode
     * @param iataCode
     * @return
     */
    public Airport findByIataCode(String iataCode) {
        Airport result = airportRepository.findByIataCode(iataCode);
        return result;
}
    
    /**
 * Retorna DTO AirportNearMe
 *
 * @param latitude
 * @param longitude
 * @return
 */
    public List<AirportNearMeDTO> findNearMe(double latitude, double longitude) {
        List<AirportNearMeProjection> resultNearAirports = airportRepository.findNearMe(latitude, longitude);

        List<AirportNearMeDTO> resultDTO = resultNearAirports.stream()
            .map(x -> new AirportNearMeDTO(x)).toList();

    return resultDTO;
}
    
}
