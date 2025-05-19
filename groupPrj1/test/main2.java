package groupPrj1;

import java.io.*;
import java.util.*;

class main2{

    public static void main(String[] args){
        
        String path = ""; //leave as blank, since if there is no specify path, the file
        //will be created/read from the same folder as this file (program file)
        
        String filepath = path + "hello.txt";
        File file = new File(filepath);

        Scanner filescanner = null;
        try
        {
            filescanner = new Scanner(file);
        }
        catch(Exception e)
        {
            System.err.println("An error occur");
            System.err.println(e);

        }


        System.out.println("Benchmark 1");

        
        String id = filescanner.nextLine();
        System.out.println(id);
        
        
        PrintWriter filewriter = null;
        try
        {
            filewriter = new PrintWriter(new FileWriter(file, true));
        }
        catch(Exception e)
        {
            System.err.println("An error occur");
            System.err.println(e);

        }

        filewriter.println("Good morning Thailand");
        filewriter.println("Good morning Thailand");
        filewriter.close();



        
    }

}