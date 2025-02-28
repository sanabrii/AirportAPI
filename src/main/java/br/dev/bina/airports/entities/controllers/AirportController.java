/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.bina.airports.entities.controllers;

import br.dev.bina.airports.entities.Airport;
import br.dev.bina.airports.repositories.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesidevb
 */
@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

   /**
     * Endpoint /airports/airport
     * Retorna TODOS os aeroportos da base de dados.
     * @return
     */
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }
    
   /**
    * Endpoint /airports/city/{cityName}
    * @param cityName
    * @return
    */
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);
        
        if (result.isEmpty()) {
            // ops.. lista vazia...
            //notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            //eba! tem dados! :0
            //ok devolve 200
        return ResponseEntity.ok(result);
        }
}

}