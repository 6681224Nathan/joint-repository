package losalamos;

import java.io.*;
import java.util.*;


class main2
{
    public static void main(String[] args){
        System.out.println("Hello world");

        try{
            File inFile = new File("countries.txt");
            File outFile = new File("output.txt");

            Scanner inFileScanner = new Scanner(inFile);
            Scanner outFileScanner = new Scanner(outFile);
            Scanner inFileScanner2 = inFileScanner;

            PrintWriter outFilePrinter = new PrintWriter( new FileWriter(outFile, false) );

            int cnt=0;

            while(inFileScanner.hasNextLine()){
                inFileScanner2.nextLine();
                cnt++;
            }
           

            countries[] countriesList = new countries[cnt];
            
            int i=0;
            while(inFileScanner.hasNext()){

                String tempcountry=inFileScanner.next();
                long temppop=inFileScanner.nextLong();
                int temparea=inFileScanner.nextInt();

                countriesList[i] = new countries(tempcountry, temppop, temparea);
                i++;
            }

            for(i=0; i<cnt; i++){

                countriesList[i].printcoun();
            }


        }
        catch(Exception e){
            System.err.println("An error occurs. End program.");
            System.err.println(e);
        }






    }
}

class countries{
    private String country;
    private long population;
    private int area;
    private double density;

    public countries()
    { 
        country="Marity"; 
        population = 0; 
        area=0;
        density = 0;
    }

    public countries(String n, long s, int a) 
    {
        country = n; 
        population = s; 
        area=a;
        density = (double)population / area;

    }

    public double get_density(){ return density;}
    public void set_density(double a){ density = a;}
    public void printcoun(){
        System.out.printf("%s %d %i %f", country, population, area, density);
    }

}