package groupPrj1;

import java.util.*;
import java.io.*;

class main2{
    public static void main(String[] args){
        
        String path = ""; //I'll change it to src/main/Java/Ex2_6580969/countries.txt
        path = path + "items.txt";
        File items = new File(path);

        Scanner filescanner = null;
        try
        {
            filescanner = new Scanner(items);
        }
        catch(Exception e){
            System.err.println(e);
        }


        int i=0;
        for(i=0; i<4; i++)
        {
            filescanner.next();
        }
        
        while(filescanner.hasNext())
        {
            System.out.print(filescanner.next() + " ");
        }

        filescanner.close();
    }
}