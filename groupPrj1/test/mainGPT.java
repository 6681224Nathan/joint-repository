package groupPrj1;

import java.io.*;
import java.util.*;

class mainGPT {

    public static void main(String[] args) {
        
        String path = ""; // leave as blank, since if there is no specified path, the file
        // will be created/read from the same folder as this file (program file)
        
        String filepath = path + "hello.txt";
        File file = new File(filepath);

        Scanner filescanner = null; // Declare the scanner before the try-catch block

        try {
            filescanner = new Scanner(file);
        } catch (Exception e) {
            System.err.println("An error occurred");
            System.err.println(e);
        }

        // Check if the scanner was successfully initialized
        if (filescanner != null) {
            System.out.println("Benchmark 1");
            String id = filescanner.nextLine();
            System.out.println(id);
            filescanner.close(); // Close the scanner
        } else {
            // Handle the case where the file couldn't be opened
            System.err.println("Could not open the file. Please check the file path.");
        }
    }
}
