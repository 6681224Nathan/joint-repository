/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex6_6681224;

//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969


import java.util.Scanner;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter target number of primes: ");
        int target = sc.nextInt();

        System.out.print("Enter number of threads: ");
        int ThreadsCount = sc.nextInt();
        
         FactorThread[] threads = new FactorThread[ThreadsCount];

        for (int i = 0; i < ThreadsCount; i++) {
            threads[i] = new FactorThread(target);
            threads[i].setName("T" + i);
            threads[i].start();
        }

        for (int i = 0; i < ThreadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
    
}




