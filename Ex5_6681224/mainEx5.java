/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// Veerapat Leepiboonsawat 6580969
// Nathan Tanaboriboon 6681224
package Ex5_6681224;

import java.io.*;
import java.util.*;
/**
 *
 * @author User
 */

class InvalidInputException extends Exception {
    // Constructor that accepts a custom message for custom exception
    public InvalidInputException(String message) {
        super(message);
    }
}

public class mainEx5 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Airline> airlines = new ArrayList<>();
        String path = "src/main/Java/Ex4_6580969/";
        path = ""; //DONT FORGET TO DISABLE, FOR LOCAL WORKING, WONT WORK WITH NETBEANS
        Scanner fileScan = createFileScanner(path, "airlines_errors.txt"); //use file scanner creator from Project 1, has Exception proof
     
        fileScan.nextLine();
        while (fileScan.hasNextLine()) {
            String line = null;
            try{
                line = fileScan.nextLine();
                String[] cols = line.split(",");

                String name = cols[0].trim();
                String code = cols[1].trim().toUpperCase();
                int aircraft = (int) Double.parseDouble( cols[2].trim() );
                int destinations = (int) Double.parseDouble( cols[3].trim() );
                
                negativeCheck(aircraft, "aircraft");
                negativeCheck(destinations, "destinations");

                airlines.add(new Airline(name, code, aircraft, destinations));
            }
            catch(Exception e)
            {
                System.err.println(e);
                System.out.println(line + "\n");
            }
            }

        
        Collections.sort(airlines);
        headerPrint();
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
                
                int threshold;
                while(true){
                    try{
                        System.out.println("Enter minimum aircraft threshold (int) : ");
                        threshold = Integer.parseInt(scan.nextLine().trim());
                        if(threshold < 0) 
                        {   
                            String thresholdStr = threshold + "";
                            throw new InvalidInputException(thresholdStr);
                        }
                        break;
                    }
                    catch(Exception e){
                        
                    }
                }
                System.out.println("Airlines with aircraft >= " + threshold + ":");
                headerPrint();
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

    /////////////////////end of main////////////////////////////////////////////////////

    public static Scanner createFileScanner(String path, String fileName) 
    {
        String filePath = path + fileName;
        File file = new File(filePath);
        Scanner keyboardScanner = new Scanner(System.in);

        Scanner fileScanner = null;

        while(fileScanner == null){
            try
            {
                fileScanner = new Scanner(file);
            }
            catch(Exception e)
            {
                System.err.println(e);
                System.out.println("Enter correct file name (with.txt) = ");
                String ia = keyboardScanner.next();
                file = new File(path + ia);
                filePath = path + ia;

            }
        }

        System.out.println("Read from " + filePath + "\n");

        return fileScanner;
    }

    public static void negativeCheck(int number, String type) throws InvalidInputException
    {
        String errorMsg = "For " + type + " : \"" + number + "\"";
        if(number < 0) throw new InvalidInputException(errorMsg);
    }

    public static void headerPrint()
    {
        System.out.println("Airline                                     Aircraft         Destinations");
        System.out.println("=========================================================================");
    }
    
}


/////////////////end of main CLASS///////////////////////////////////////////////////////////////////



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
        String localCode = code + ")";
        return String.format("%-30s (%-5s %14d %20d", name, localCode, aircraft, destinations);
    }
  
 
  
  
  
  
 
}
