/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;
//import packages required 
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Rachael Siderius
 */
public class FileHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare variable to access file
        //works properly on my personal computer
        File textFile = new File("C:\\Users\\Siderius Family\\Documents\\NetBeansProjects\\source.txt");

        //use if statement to check if the file has already been created
        if (textFile.exists()) {
            //Inform user that the file already exists
            System.out.println("File exists");
        }
        
        //run code if file doesn't already exist
        else {
            
            //use try-catch to catch errors
            try {
                //create the new file
                textFile.createNewFile();
                //inform user that the file has been created
                System.out.println("File created");
            }
            
            //catch errors
            catch(IOException e ){
                //inform user of error that occured
                System.err.println("IOException" + e.getMessage());
            }        
        }
        // create a scanner to get a phrase or sentence from the user
        Scanner input = new Scanner(System.in);
        
        //declare variables usec to write to file
        FileWriter write;
        BufferedWriter writeFile;
        String inputText;
        
        //use try-catch to find errors
        try{
            
            //declare variables to be used to write to file
            write = new FileWriter(textFile);
            writeFile = new BufferedWriter (write);
            
            //prompt user for the text they want analysed
            System.out.println("Enter text to be analysed: ");
            inputText = input.nextLine();
            
            //write the text entered into the file
            writeFile.write(inputText);
            writeFile.newLine();
                
            //end writing 
            writeFile.close();
            write.close();
            System.out.println("Data stored");
        }
        
        //catch error when file is not available
        catch(FileNotFoundException e ){
            //inform user
            System.err.println("File not found");
        }
        
        //catch IO exceptions
        catch (IOException e ) {
            //inform user of the errror
            System.err.println("IOException" + e.getMessage());
        }
        
        
        
        
        //declare variables used to read file
        FileReader reader;
        BufferedReader readSource;
        String lineOfText;
        
        //use try-catch to find errors that could occur
        try {

            //declare variables used to read the file
            reader = new FileReader(textFile);
            readSource = new BufferedReader(reader);

            
            while((lineOfText = readSource.readLine()) != null){
                
                System.out.println(lineOfText);
            }
            readSource.close();
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");

        }
        catch (IOException e) {
           System.out.println("IO exception");
        }

    }
    
}
