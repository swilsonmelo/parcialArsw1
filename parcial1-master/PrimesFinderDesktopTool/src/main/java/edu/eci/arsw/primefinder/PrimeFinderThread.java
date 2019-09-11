package edu.eci.arsw.primefinder;

import java.math.BigInteger;

public class PrimeFinderThread extends Thread {

    private BigInteger start, finish;
    
	

    private PrimesResultSet primes;

    public PrimeFinderThread(BigInteger _a, BigInteger _b,PrimesResultSet prs ){
        this.start = _a;
        this.finish = _b;
        this.primes = prs;
    }


    


    @Override
    public void run(){
        synchronized(primes){
            PrimeFinder.findPrimes(start, finish, primes);
        }
        System.out.println(primes.getPrimes());
    }

}