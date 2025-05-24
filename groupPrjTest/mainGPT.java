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
        System.out.printf("%s %s %d\n", code, name, unit_price);  
    }

}

class mainGPT{
    public static void main(String[] args){

        //basic essential variables 

        Scanner keyboardScanner = new Scanner(System.in);
        int i=0;
        String path = ""; //I'll change it to src/main/Java/Ex2_6580969/countries.txt
        Items[] itemsList = new Items[6];
        
        
        //extract information from items.txt

        File itemsFile = new File(path + "items.txt");
        Scanner itemsScanner = null;

        while(itemsScanner == null){
            try
            {
                itemsScanner = new Scanner(itemsFile);
            }
            catch(Exception e)
            {
                System.err.println(e);
                System.out.println("Enter correct file name (with.txt) = ");
                String ia = keyboardScanner.next();
                itemsFile = new File(path + ia);

            }
        }

        ////////////////////


        
        for(i=0; i<4; i++) //4, because unit"space"price
        {
            itemsScanner.next(); //skip the first line
        }

        // Skip the header lines
    
        for(i=0; i<6 && itemsScanner.hasNextLine(); i++) {
            String line = itemsScanner.nextLine().trim();
            if (line.isEmpty()) continue;
            
            // Split on commas followed by optional whitespace
            String[] parts = line.split(",\\s*", 3);
            
            if (parts.length < 3) continue; // skip malformed lines
            
            String Code = parts[0].trim();
            String Name = parts[1].trim();
            int Unit_price = Integer.parseInt(parts[2].trim());
            
            itemsList[i] = new Items(Code, Name, Unit_price);
            itemsList[i].printItems();
        }

        
        
        
        itemsScanner.close();
        keyboardScanner.close();
    }
}