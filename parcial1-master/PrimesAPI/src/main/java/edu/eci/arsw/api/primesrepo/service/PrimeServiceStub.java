package edu.eci.arsw.api.primesrepo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

/**
 * @author Santiago Carrillo 2/22/18.
 * 
 * 
 */
@Component
public class PrimeServiceStub implements PrimeService
{
    private final Map<String,FoundPrime> fps = new HashMap<>();

    @Override
    public void addFoundPrime(FoundPrime foundPrime) throws Exception
    {
        
        if (fps.containsKey(foundPrime.getPrime())){
            throw new Exception("The prime already exists: "+ fps);
        }
        else{
            fps.put(foundPrime.getPrime(),foundPrime);
        }     
        fps.put(foundPrime.getPrime(),foundPrime); 
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        List<FoundPrime> foundPrimes = new ArrayList<FoundPrime>();
        for(String p : fps.keySet()){
            foundPrimes.add(fps.get(p));
        }
        return foundPrimes;
    }

    @Override
    public FoundPrime getPrime(String prime) throws Exception
    {
        FoundPrime fp;
        fp = fps.get(prime);
        
        if(fp == null){
            throw new Exception("The prime doesn´t exists");
        }
        return fp;
    }
}
