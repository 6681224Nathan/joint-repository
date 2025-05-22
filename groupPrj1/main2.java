package groupPrj1;

import java.util.*;
import java.io.*;

class InvalidInputException extends Exception {
    // Constructor that accepts a custom message
    public InvalidInputException(String message) {
        super(message);
    }
}


class Items{
    private String code;
    private String name;
    private int unit_price;

    public Items()
    {
        code = "missing";
        name = "missing";
        unit_price = -1;
    }

    public Items(String Code, String Name, int Unit_price)
    {
        code=Code;
        name=Name;
        unit_price=Unit_price;
    }

    public void set_code(String a){ code =a;}
    public void set_name(String a){ name =a;}
    public void set_unit_price(int a){ unit_price =a;}

    public String get_code(){ return code;}
    public String get_name(){ return name;}
    public int get_unit_price(){ return unit_price;}

    public void printItems()
    {
        System.out.printf("%s %s %i\n", code, name, unit_price);    
    }

}

class Discount{
    private ArrayList<Double> discountPrice;
    private ArrayList<Double> discountPercent;

    public Discount()
    {
        discountPrice = new ArrayList<>();
        discountPercent = new ArrayList<>();
    }

    public void addDiscount(double price, double percent)
    {
        discountPrice.add(price);
        discountPercent.add(percent);
    }

    public double applyDiscount(double price)
    {
        for(int i=0; i<discountPrice.size() ; i++)
        {
            if(price >= discountPrice.get(i))
            {
                price = price * ( 1 - discountPercent.get(i)/100 );
            }
        }

        return price;
    }

}

class Booking{
    private String bookings;
    private String customers;
    private int days;
    private int[] rooms;
    private int persons;
    private int[] meals;
    private int price;

    public Booking(String B, String C, int D, int[] R, int P, int[] M)
    {
        bookings = B;
        customers = C;
        days =  D;
        rooms = R.clone(); //array
        persons = P;
        meals = M.clone(); //array
        price = 0;
    }
    
    //booking, customer, days, rooms/day(R1:R2:R3), persons, meals/person/day(M1:M2:M3)
}


class main2{
    public static void main(String[] args){

        //basic essential variables 

        Scanner keyboardScanner = new Scanner(System.in);
        int i=0;
        String path = ""; //I'll change it to src/main/Java/Ex2_6580969/countries.txt
        
        
        //////////////////opening the items file, and read from it
        
        Items[] itemsList = new Items[6];

        Scanner itemsScanner = createFileScanner(path, "items.txt");


        //////////////////////get the information from "items.txt" file to 6 objects

        itemsScanner.nextLine(); //skip the header line
        for(i=0; itemsScanner.hasNext(); i++)
        {
            String line   = itemsScanner.nextLine();        
            String []cols = line.split(",");        
            trimArray(cols);

            String Code = cols[0];
            String Name = cols[1];
            int Unit_price = Integer.parseInt(cols[2]);

            System.out.printf("%s %s %d\n", Code, Name, Unit_price);
            itemsList[i] = new Items(Code, Name, Unit_price);
        }

        /////////////////////////opening discount flies
        
        Scanner discountsScanner = createFileScanner(path, "discounts.txt");
        Discount discounts = new Discount();

        discountsScanner.nextLine(); //skip header line
        for(i=0; discountsScanner.hasNextLine(); i++)
        {
            String line = discountsScanner.nextLine();
            String []cols = line.split(",");
            trimArray(cols);
            
            if(cols.length < 2) continue;
            
            double discountPrice = Double.parseDouble(cols[0]);
            double discountPercent = Double.parseDouble(cols[1]);
            System.out.printf("Price : %10.2f Criteria : %-7.2f\n", discountPrice, discountPercent);
            discounts.addDiscount(discountPrice, discountPercent);
            
        }
        
        /////////////////////////opening the bookings file, and read from it
        
        Scanner bookingsScanner = createFileScanner(path, "bookings_errors.txt");

        ArrayList<Booking> bookings = new ArrayList<Booking>();

        bookingsScanner.nextLine(); //skip header line
        for(i=0; bookingsScanner.hasNext(); i++)
        {
            String line = bookingsScanner.nextLine();
            try
            {
                String []cols = line.split(",");
                trimArray(cols);
                
                String bookingName = cols[0];
                String customers = cols[1];
                int days =  Integer.parseInt(cols[2]);
                negativeCheck(days, "days");
                
                int [] rooms = stringArrayToInt(cols[3]);

                int persons = Integer.parseInt(cols[4]);
                negativeCheck(persons, "persons");
                
                int [] meals = stringArrayToInt(cols[5]);

                System.out.printf("%-3s %s %-2d %d:%d:%d %-3d %d:%d:%d\n",bookingName,customers,days,rooms[0]
                ,rooms[1],rooms[2],persons,meals[0],meals[1],meals[2]);
                
            }
            catch(Exception e)
            {
                System.err.println(e);
                System.out.printf("%s%5s%s", line, " ", "skip\n\n");
            }
            
        }
            
        
        
        
        itemsScanner.close();
        discountsScanner.close();
        bookingsScanner.close();
        keyboardScanner.close();
    }

    ////////////////end of main, following these will be functions for main, for repeated use/////////////////////////////

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

            }
        }

        return fileScanner;
    }

    public static void trimArray(String[] cols)
    {
        for(int i=0; i<cols.length; i++)
        {
            cols[i] = cols[i].trim();
        }
    }

    public static void negativeCheck(int number, String type) throws InvalidInputException
    {
        String errorMsg = "For " + type + " : \"" + number + "\"";
        if(number < 0) throw new InvalidInputException(errorMsg);
    }

    public static int[] stringArrayToInt(String cols) throws InvalidInputException, NumberFormatException
    {
        int [] rooms = new int[3]; 
        String[] roomString = cols.split(":"); 
        if(roomString.length != 3) throw new InvalidInputException("For rooms : \"" + cols + "\"");

        for(int j=0; j<roomString.length; j++)
        {   
            rooms[j] = Integer.parseInt(roomString[j]);
            negativeCheck(rooms[j], "rooms");
        }

        return rooms;
    }




    
}