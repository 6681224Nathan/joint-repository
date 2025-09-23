package exercise_2_Pin;

import java.io.*;
import java.util.*;


class main2
{
    public static void main(String[] args){
        System.out.println("Hello world");

        try{
            
            int i=0;
            Scanner keyboardScanner = new Scanner(System.in);

            File inFile = new File("countries.txt");
            File outFile = new File("output.txt");
            
            PrintWriter outFilePrinter = new PrintWriter( new FileWriter(outFile, false) );

            Scanner inFileScanner = new Scanner(inFile);
            Scanner inFileScanner2 = new Scanner(inFile);
            Scanner outFileScanner = new Scanner(outFile);
            //System.out.println("2"); //debugger


            int cnt=0;

            while(inFileScanner2.hasNextLine()){
                inFileScanner2.nextLine();
                cnt++;
            }

            System.out.println("Number of countries " + cnt);
           

            countries[] countriesList = new countries[cnt];

            
            
            i=0;
            while(inFileScanner.hasNext()){

                String tempcountry=inFileScanner.next();
                double temppop=inFileScanner.nextDouble();
                double temparea=inFileScanner.nextDouble();

                countriesList[i] = new countries(tempcountry, temppop, temparea);
                i++;
            }

            //debugger, check whether object is null or not, check problem of cnt, if it is 0, possibly
            for (i = 0; i < cnt; i++) {
                if (countriesList[i] != null) {
                    countriesList[i].printCoun();
                } else {
                    System.err.println("Error: country at index " + i + " is null.");
                }
            }

            System.out.println("Enter density threshold = ");
            double ia = keyboardScanner.nextDouble();
            countries.set_density_threshold(ia);

        

            for(i=0; i<cnt; i++){
                //print everything out in terminal
                countriesList[i].printCoun();
            }

            outFilePrinter.printf("%-12s %15s     %-10s %20s     %-4s %10s %6s\n",
             "Country", "Population", "", "Area(km2)", "", "Density", "(>" + countries.get_density_threshold() + "?)");
            outFilePrinter.println("=================================================================================================================");

            // Write data
            for (i = 0; i < cnt; i++) {
                countriesList[i].writeCoun(outFilePrinter);
            }


            //FILE IS CLOSING
            
            outFilePrinter.close();
            outFileScanner.close();

            System.out.println("Do you want to delete the output.txt? 0 for yes, 1 for no");
            int answer = keyboardScanner.nextInt();
            if(answer == 0){
                if(outFile.exists()) outFile.delete();
            }

            keyboardScanner.close();

            inFileScanner.close();
            inFileScanner2.close(); 




        }
        catch(Exception e){
            System.err.println("An error occurs. End program.");
            System.err.println(e);
        }






    }
}

class countries{
    private String country;
    private double population;
    private double area;
    private double density;
    private static double density_threshold;

    public countries()
    { 
        country="Marity"; 
        population = 0; 
        area=0;
        density = 0;
        density_threshold=0;
    }

    public countries(String n, double s, double a) 
    {
        country = n; 
        population = s; 
        area=a;
        density = population / area;
        density_threshold=0;

    }

    public double get_density(){ return density;}
    public void set_density(double a){ density = a;}
    public static double get_density_threshold(){ return density_threshold;}
    public static void set_density_threshold(double a){ density_threshold = a;}
    public void printCoun(){
        System.out.printf("%s %.0f %.0f %.2f %.2f\n", country, population, area, density, density_threshold);
    }

    public String numtostr(double a){
        if (a < 1_000) {
            return String.format("%.0f", a);
        } else if (a < 1_000_000) {
            return String.format("%.1f K", a / 1_000.0);
        } else if (a < 1_000_000_000) {
            return String.format("%.1f M", a / 1_000_000.0);
        } else {
            return String.format("%.1f B", a / 1_000_000_000.0);
        }
    }

   public void writeCoun(PrintWriter writer){
    String popFull = String.format("%,.0f", population);
    String popShort = numtostr(population);

    String areaFull = String.format("%,.0f", area);
    String areaShort = numtostr(area);

    String densityFormatted = String.format("%.1f", density);
    String isOver;
    if (density > density_threshold) {
        isOver = "yes";
    } else {
        isOver = "no";
    }

    writer.printf("%-12s %15s = %-9s %17s = %-9s %10s %4s\r\n",
        country,
        popFull, popShort,
        areaFull, areaShort,
        densityFormatted, isOver
    );
    
    }

}