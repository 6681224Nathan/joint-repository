/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// Veerapat Leepiboonsawat 6580969
// Nathan Tanaboriboon 6681224
package Ex4_6580969;

import java.io.*;
import java.util.*;
/**
 *
 * @author User
 */
public class NewMainEx3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Scanner scan = new Scanner(System.in);
        ArrayList<Airline> airlines = new ArrayList<>();
        String path = "src/main/Java/Ex4_6580969/airlines.txt";
        //path = "airlines.txt";
     
        try {
            Scanner fileScan = new Scanner(new File(path));
            if (fileScan.hasNextLine()) fileScan.nextLine(); // skip header

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                String[] cols = line.split(",");

                String name = cols[0].trim();
                String code = cols[1].trim();
                int aircraft = Integer.parseInt(cols[2].trim());
                int destinations = Integer.parseInt(cols[3].trim());

                airlines.add(new Airline(name, code, aircraft, destinations));
            }

            fileScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
            return;
        }

        
        Collections.sort(airlines);
        System.out.println("Sorted Airlines:");
        for (Airline a : airlines) {
            System.out.println(a);
        }
        

      
        while (true) {
            System.out.println("\nChoose an option: [1] Search  [2] Filter  [3] Quit");
            String choice = scan.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter ICAO code to search: ");
                String code = scan.nextLine().trim();
                Airline key = new Airline("", code);
                int index = airlines.indexOf(key);

                if (index >= 0) {
                    System.out.println("Airline found:");
                    System.out.println(airlines.get(index));
                } else {
                    System.out.println("Code not found.");
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter minimum aircraft threshold: ");
                int threshold = Integer.parseInt(scan.nextLine().trim());

                System.out.println("Airlines with aircraft >= " + threshold + ":");
                for (Airline a : airlines) {
                    if (a.getAircraft() >= threshold) {
                        System.out.println(a);
                    }
                }

            } else if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scan.close();
    }
    
}

class Airline implements Comparable<Airline> {
  private String name, code;
  private int aircraft, destinations;
  
 public Airline(String name, String code){
     this(name, code, 0, 0);
 }
  
 public Airline(String name, String code, int aircraft, int destinations){
    this.name = name;
    this.code = code;
    this.aircraft = aircraft;
    this.destinations = destinations;
  }
  
  
 
  
  public String getName(){return name;}
  public String getCode(){return code;}
  public int getAircraft(){return aircraft;}
  public int getDestinations(){return destinations;}
  
   @Override
  public int compareTo(Airline other){
      if (this.aircraft != other.aircraft)
            return other.aircraft - this.aircraft; 

        if (this.destinations != other.destinations)
            return other.destinations - this.destinations;

        return this.name.compareToIgnoreCase(other.name); //this will compare the alphabetical order of two strings, first letter, if first letter is equal, then second
                                                        // letter and so on, found on the internet
  }
  @Override
  public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Airline)) return false;
        Airline other = (Airline) obj;
        return this.code.equalsIgnoreCase(other.code); //this will check whether two strings are equal, by ignoring some cases like uppercase letter
                                                        //found on the internet as well
  }
  @Override
    public String toString() {
        return String.format("%-30s %-5s %6d %6d", name, code, aircraft, destinations);
    }
  
 
  
  
  
  
 
}
