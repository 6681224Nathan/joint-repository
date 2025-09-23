/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// Veerapat Leepiboonsawat 6580969
// Nathan Tanaboriboon 6681224
package Ex2_6580969;

import java.util.*;
import java.io.*;

public class NewMain1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int th = input.nextInt();
        input.nextLine();
        input.close();
        String C = "Country";
        String P = "Population";
        String A = "Area";
        String D = "Density";
        String X = th + "";

        try {

            File Fi = new File("src/main/Java/Ex2_6580969/countries.txt");
            Scanner fileinput = new Scanner(Fi);

            PrintWriter output = new PrintWriter(new FileWriter("src/main/Java/Ex2_6580969/output.txt", false));
            
            System.out.printf("%-15s %15s %25s %25s (>%4s?)%n", C, P, A, D, X);
            System.out.println("============================================================================================");
            output.printf("%-15s %15s %25s %25s (>%4s?)%n", C, P, A, D, X);
            output.printf("============================================================================================%n");

            while (fileinput.hasNext()) {
                String country = fileinput.next();
                int population = fileinput.nextInt();
                int area = fileinput.nextInt();
                double Pdensity = (double) population / area;
                String U;
                String Z;
                if (Pdensity > th) {
                    U = "Yes";
                    Z = String.format("%-15s %15d = %9s %15d = %9s %10.1f %6s%n", country, population, formating(population), area, formating(area), Pdensity, U);
                    
                } else {
                    U = "NO";
                    Z= String.format("%-15s %15d = %9s %15d = %9s %10.1f %6s%n", country, population, formating(population), area, formating(area), Pdensity, U);
                   
                }
                System.out.print(Z);
                output.print(Z);

            }
            fileinput.close();
            output.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static String formating(double n) {
//        if (n >= 1_000_000_000) {
//            return (n / 1_000_000_000) + "B";
//        } else if (n >= 1_000_000) {
//            return (n / 1_000_000) + "M";
//        } else if (n >= 1_000) {
//            return (n / 1_000) + "K";
//        }else{
//            return n + "";
//    }
        if (n >= 1_000_000_000) {
            return String.format("%7.1f B", n / 1_000_000_000);
        } else if (n >= 1_000_000) {
            return String.format("%7.1f M", n / 1_000_000);
        } else if (n >= 1_000) {
            return String.format("%7.1f K", n / 1_000);
        } else {
            return String.format("%7.0f", n);
        }
    }

}
