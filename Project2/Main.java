package Project2;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

import java.util.concurrent.CyclicBarrier;

class Main
{
    public static void main(String[] args)
    {
        try{
            String path = "src/main/java/Project2_6681224/";
            File configFile = new File(path + "config_1.txt");
            Scanner sc = new Scanner(configFile);

            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found exception");
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}