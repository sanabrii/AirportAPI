/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.dev.bina.airports.repositories;

import br.dev.bina.airports.entities.Airport;
import br.dev.bina.airports.entities.projections.AirportNearMeProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author sesidevb
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    List<Airport> findByCityIgnoreCase(String city);
    List<Airport> findByCountryIgnoreCase(String contry);
    
    Airport findByIataCode(String iataCode);
    
    @Query(nativeQuery = true, value = """
        SELECT
            airport.id,
            airport.name,
            airport.city,
            airport.iatacode,
            airport.latitude,
            airport.longitude,
            airport.altitude,
            SQRT(
                power(airport.latitude - -23.164400, 2 ) +
                power(airport.longitude - -45.896675, 2)) * 60 * 1.852 as distanciaKM
                        
        from AIRPORT
        order by distanciaKM
        limit 10;"""
    )
    List<AirportNearMeProjection> findNearMe(double latitude, double longitude);

   
    
}
