package edu.eci.arsw.api.primesrepo.service;

import java.util.List;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
public interface PrimeService
{

    void addFoundPrime( FoundPrime foundPrime )throws Exception ;

    List<FoundPrime> getFoundPrimes();

    FoundPrime getPrime( String prime ) throws Exception;

}
