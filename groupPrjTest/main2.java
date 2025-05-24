package groupPrj1;

import java.util.*;
import java.io.*;

class InvalidInputException extends Exception {
    // Constructor that accepts a custom message for custom exception
    public InvalidInputException(String message) {
        super(message);
    }
}


class Items_AL{
    private ArrayList<String> code;
    private ArrayList<String> name;
    private ArrayList<Double> unit_price;

    public String get_code(int i) {return code.get(i);}
    public String get_name(int i) {return name.get(i);}
    public double get_unit_price(int i) {return unit_price.get(i);}

    public Items_AL()
    {
        code = new ArrayList<String>();
        name = new ArrayList<String>();
        unit_price = new ArrayList<Double>();
    }

    public void addItems(String Code, String Name, double Unit_price) throws InvalidInputException
    {
        
        code.add(Code);
        name.add(Name);
        unit_price.add(Unit_price);

        /*System.out.printf("Items added : %s %s %f.0\n", code.get(code.size()-1), name.get(name.size()-1)
        ,unit_price.get(unit_price.size()-1)); */

    }

    public void printItems()
    {
        int i=0;
        for(i=0; i<3; i++)
        {
            System.out.printf("%s, %-20s rate (per day) = %,9.2f   rate++ = %,9.2f\n"
            , code.get(i), name.get(i), unit_price.get(i), unit_price.get(i)*1.07*1.1);
        }
        System.out.println(" ");

        for(i=i; i<6; i++)
        {
            System.out.printf("%s, %-15s rate (per person per day) = %,7.2f\n"
            , code.get(i), name.get(i), unit_price.get(i), unit_price.get(i)*1.07*1.1);
        }
        System.out.println(" ");
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

    public double checkDiscount(double price)
    {
        double discountPercentTemp=0;
        for(int i=0; i<discountPrice.size() ; i++)
        {
            if(price >= discountPrice.get(i))
            {
                discountPercentTemp = discountPercent.get(i);
            }
        }

        return discountPercentTemp;
    }

    public void printDiscount()
    {
        for(int i=discountPercent.size()-1; i>-1; i--)
        {
            System.out.printf("If total bill >= %,10.0f   discount = %4.1f%%\n"
            ,discountPrice.get(i), discountPercent.get(i));
        }
        System.out.println("");
    }

}

class Booking{
    private String bookings;
    private String customers;
    private int days;
    private int[] rooms;
    private int persons;
    private int[] meals;
    private double price;

    private Items_AL itemsAL;
    private Discount discountAL;

    public String get_bookings(){ return bookings;}
    public String get_customers(){ return customers;}

    public Booking(String B, String C, int D, int[] R, int P, int[] M, Items_AL I, Discount Dis)
    {
        bookings = B;
        customers = C;
        days =  D;
        rooms = R.clone(); //array
        persons = P;
        meals = M.clone(); //array
        price = 0;

        itemsAL = I;
        discountAL = Dis;

    }

    public double printBookings()
    {
        double room_price = 0;
        double meal_price = 0;

        for(int i=0; i<=2; i++)
        {
            room_price = room_price + rooms[i] * itemsAL.get_unit_price(i);
            meal_price = meal_price + meals[i] * itemsAL.get_unit_price(i+3);
        }

        room_price = room_price * days * 1.1 * 1.07; //1.1 is service charge, 1.07 is vat
        meal_price = meal_price * days * persons; //no vat for meal
        
        double sub_total = (double)(room_price + meal_price);
        
        double discount_percent = discountAL.checkDiscount(sub_total);
        double discount= discount_percent/100 * sub_total;
        double total = sub_total - discount;

        System.out.printf("Booking %3s, customer %3s  >>  days = ", bookings, customers);
        System.out.printf("%2d, persons = %3d, rooms = [%d, %d, %d], meals = [%d, %d, %d]\n"
        , days, persons,rooms[0],rooms[1],rooms[2],meals[0],meals[1],meals[2]);
        System.out.printf("%12s %-19s = %,17.2f\n", " ", "total room price++", room_price);
        System.out.printf("%12s %-19s = %,17.2f\n", " ", "total meal price", meal_price);
        System.out.printf("%12s %-19s = %,17.2f\n", " ", "sub-total", sub_total);
        if(discount != 0)
        {
            System.out.printf("%12s %-19s = %,17.2f\n", " ",String.format("discount %4s", " ") , discount);
        }
        else
        {
            System.out.printf("%12s %-19s = %,17.2f\n", " ",String.format("discount %2.1f%%", discount_percent) , discount);
        }
        System.out.printf("%12s %-19s = %,17.2f\n", " ", "total", total);
        System.out.println("");

        return sub_total;


    }

}

class Customers implements Comparable<Customers>
{
    private String name;
    private ArrayList<String> bookings;
    private double price;

    public String get_name(){ return name;}
    

    public Customers(String name, String bookings, double price)
    {
        this.name=name;
        this.bookings = new ArrayList<>();
        this.bookings.add(bookings);
        this.price = price;
    }

    public void addCustomers(String bookings, double price)
    {
        this.bookings.add(bookings);
        this.price = this.price + price;
    }

    @Override
    public int compareTo(Customers other)
    {
	if (this.price < other.price)       return -1;	
	else if (this.price > other.price)  return 1;	
	else                                return 0;
    }

    public void printCustomers()
{
    System.out.printf("%5s >> total amount = %,12.2f   bookings = [", name, price);
    for(int i=0; i<bookings.size(); i++)
    {
        System.out.print(bookings.get(i));
        if(i != bookings.size() - 1) System.out.print(" , ");
    }
    System.out.println("]");
}


}

/////////////////////////////////////////////////////Start of main//////////////////////////////////////////////

class main2{
    public static void main(String[] args){

        //basic essential variables 

        Scanner keyboardScanner = new Scanner(System.in);
        int i=0;
        String path = ""; //I'll change it to src/main/Java/Project1_6681224
        
        
        //////////////////opening the items file, and read from it

        Scanner itemsScanner = createFileScanner(path, "items.txt");
        Items_AL items = new Items_AL();

        itemsScanner.nextLine(); //skip the header line
        for(i=0; itemsScanner.hasNext(); i++)
        {
            String line   = itemsScanner.nextLine();
            try{        
                String []cols = line.split(",");        
                trimArray(cols);

                String Code = cols[0];
                String Name = cols[1];
                double Unit_price = Double.parseDouble(cols[2]);

                items.addItems(Code, Name, Unit_price);
            }
            catch(Exception e)
            {
                System.err.println(e);
                System.out.printf("%s%5s%s", line, " ", "skip\n\n");
            }
        }
        items.printItems();

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
            //System.out.printf("Price : %12.2f Criteria : %-9.2f\n", discountPrice, discountPercent);
            discounts.addDiscount(discountPrice, discountPercent);
            
        }
        discounts.printDiscount();
        
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

                /*System.out.printf("%-3s %s %-2d %d:%d:%d %-3d %d:%d:%d\n",bookingName,customers,days,rooms[0]
                ,rooms[1],rooms[2],persons,meals[0],meals[1],meals[2]);*/

                bookings.add(new Booking(bookingName, customers, days, rooms, persons, meals, items, discounts));
 

                
            }
            catch(Exception e)
            {
                System.err.println(e);
                System.out.printf("%s%5s%s", line, " ", "skip\n\n");
            }
            
        }

        System.out.printf("\n===== Booking processing =====\n");
        ArrayList<Customers> customersAL = new ArrayList<>();

        for(Booking booking : bookings)
        {
            Double total = booking.printBookings();
            String customerName = booking.get_customers();
            boolean found=false;

            for(Customers customer : customersAL)
            {
                if( customer.get_name().equals( customerName ) )
                {
                    customer.addCustomers(booking.get_bookings(), total);
                    found = true;
                    break;
                }
            }

            if(found == false)
            {
                customersAL.add(new Customers(customerName, booking.get_bookings(), total));
            }

        }

        Collections.sort(customersAL);

        System.out.printf("\n===== Customer summary =====\n");

        for(i=customersAL.size()-1; i>-1; i--)
        {
            customersAL.get(i).printCustomers();
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

        System.out.println("Read from " + filePath);

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