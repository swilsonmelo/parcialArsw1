package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder{
        
  
	
    public static void ranges(BigInteger _a, BigInteger _b, PrimesResultSet prs )    {
        List<PrimeFinderThread> threads = new ArrayList<PrimeFinderThread>();
        BigInteger a=_a;
        BigInteger b=_b;
        BigInteger nThread = new BigInteger("4");
        BigInteger part = (b.subtract(a)).divide(nThread);

        for(int i = 0; i < 4; i++){
            BigInteger fini = a.add(part);
            //System.out.println("ini " + a);
            //System.out.println("fini " + fini);
            PrimeFinderThread tempThread = new PrimeFinderThread(a, fini, prs);
            threads.add(tempThread);
            tempThread.start();
            a = fini.add(BigInteger.ONE);
            
        }

        
    }


	public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs){
            
                BigInteger a=_a;
                BigInteger b=_b;
                //System.out.println(a + " " + b);
                MathUtilities mt=new MathUtilities();
                
                int itCount=0;
            
                BigInteger i=a;
                while (i.compareTo(b)<=0){
                    itCount++;
                    if (mt.isPrime(i)){
                        synchronized(prs){
                            prs.addPrime(i);
                            //System.out.println("kha "+ i);
                        }
                    }

                    i=i.add(BigInteger.ONE);
                }
                
	}
	
	
	
	
	
}
