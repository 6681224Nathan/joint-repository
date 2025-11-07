/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 //Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Ex6_6681224;
import java.io.*;
import java.util.*;
/**
 *
 * @author User
 */
public class FactorThread extends Thread {
 private PrintWriter out;
 private ArrayList<Integer> allPrimes;
 private int target;
 private static Random rand = new Random();
 
  public FactorThread(int target) {
        this.target = target;
        this.allPrimes = new ArrayList<>();
  }
 @Override
 public void run() {
    // Create PrintWriter object to write result to a separate file
    // Execute steps 1-3 in loop until #primes = target:
    // 1. Random a value v in range [100, 500] and find all its positive factors (i.e.
    // integers that divide it with 0 remainder.
    //
    // 2. If v is a prime: print round number, v, current #primes to file as in demo.
    // 3. If v is not a prime: print round number, v, its factors to file as in demo.
    // After the loop, print thread name, #rounds, all primes (sorted in increasing order)
    // to the screen.
    String Filename = this.getName()+ ".txt";
    int round = 1;
    try{
        out = new PrintWriter(new FileWriter("src/main/java/Ex6_6681224/" + Filename));
        
    }catch (IOException e) {
                e.printStackTrace();
                return;
    }
        
        while(allPrimes.size() < target){
        round++;
        int v = rand.nextInt(401)+ 100;
        List<Integer> factors = getFactors(v);        
            if (isPrime(v)) {
                    allPrimes.add(v);
                    out.printf("Round %3d >> %d = prime   #primes = %d\n", round, v, allPrimes.size());
                } else {
                    out.printf("Round %3d >> %d           factors = %s\n", round, v, factors.toString());
                }
        }
        
        out.close();
        
        Collections.sort(allPrimes);
        System.out.printf("%s finished after %d round, Primes = "+ allPrimes + "%n", getName(),round);
        
        
 }
  private List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                factors.add(i);
        }
        return factors;
    }
  private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
  
}
