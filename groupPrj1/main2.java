package groupPrj1;

import java.util.*;
import java.io.*;

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
        
        
        //////////////////check the existence of the file, and read from it
        Items[] itemsList = new Items[6];

        Scanner itemsScanner = createFileScanner(path, "items.txt");


        //////////////////////get the information from "items.txt" file to 6 objects

        itemsScanner.nextLine(); //skip the header line
        for(i=0; itemsScanner.hasNext(); i++)
        {
            String line   = itemsScanner.nextLine();        
            String []cols = line.split(",");        
            
            String Code = cols[0].trim();
            String Name = cols[1].trim();
            int Unit_price = Integer.parseInt(cols[2].trim());

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
            
            if(cols.length < 2) continue;
            
            double discountPrice = Double.parseDouble(cols[0].trim());
            double discountPercent = Double.parseDouble(cols[1].trim());
            System.out.printf("Price : %10.2f Criteria : %-7.2f\n", discountPrice, discountPercent);
            discounts.addDiscount(discountPrice, discountPercent);
            
        }
        

        /////////////////////////opening the bookings file
        
        Scanner bookingsScanner = createFileScanner(path, "bookings.txt");

        ArrayList<Booking> bookings = new ArrayList<Booking>();

        bookingsScanner.nextLine(); //skip header line
        for(i=0; bookingsScanner.hasNextLine(); i++)
        {
            try
            {
                String line = bookingsScanner.nextLine();
                String []cols = line.split(",");
                
                
                String bookingName = cols[1].trim();
                String customers = cols[2].trim();
                int days =  Integer.parseInt(cols[3].trim());
                int[] rooms = cols[4].split(":");
                int persons = 4;
                int[] meals = M.clone();
                
                if(cols.length < 6) continue;
                
                double discountPrice = Double.parseDouble(cols[0].trim());
                double discountPercent = Double.parseDouble(cols[1].trim());
                System.out.printf("Price : %10.2f Criteria : %-7.2f\n", discountPrice, discountPercent);
                discounts.addDiscount(discountPrice, discountPercent);
            }
            catch(Exception e)
            {
                
            }
            
        }
            
        
        
        
        itemsScanner.close();
        discountsScanner.close();
        bookingsScanner.close();
        keyboardScanner.close();
    }

    ////////////////end of main, following these will be functions for main, for repeated use

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

    public static int arrayParseInt(String[] stringNumber)
    {
        int[] intNumber = new int[stringNumber.length];
        for(int i=0; i<stringNumber.length; i++)
        {
            intNumber[i] = Integer.parseInt(stringNumber[i].trim());
        }

        return intNumber;
    }


    
}