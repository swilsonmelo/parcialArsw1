package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController
@RequestMapping(value = "/primes")
public class PrimesController
{
    @Autowired
    PrimeService primeService;


    @RequestMapping( value = "", method = GET )
    public List<FoundPrime> getPrimes()
    {
        return primeService.getFoundPrimes();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorPostBlueprints(@RequestBody FoundPrime fp) {
        try{
            primeService.addFoundPrime(fp);
            return new ResponseEntity<>("Created",HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Error - Not created", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{prime}" ,method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoBlueprint(@PathVariable String prime) {
        try{
            System.out.println(primeService.getPrime(prime));
            return new ResponseEntity<>(primeService.getPrime(prime), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Error - Not Found", HttpStatus.NOT_FOUND);
        }
    }


    //TODO implement additional methods provided by PrimeService



}
