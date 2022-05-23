package com.test.filemanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter n to create new text file, i for all the information of that file, w to write sometihng to that file, r to read information from that file and bye to exit: ");
            String input = scanner.nextLine();
            
            if(input.equals("n")) {
                NewFile();
           }
            if(input.equals("i")) {
                information();
            }
            if(input.equals("w")) {
                writing();
            }
            if(input.equals("r")) {
                reading();
            }
            if(input.equals("bye")) {
                break;
            }
            else {
                System.out.println("Please choose what is mentioned");
            }
        }
    }
        public static void NewFile() {
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("Where do you want to store the file(absolute location with file name): ");
                String location = scanner1.nextLine();
                File myObj = new File(location);
                if(myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());   
                }
                else {
                    System.out.println("File already exists");
                }
            } catch(IOException e) {
                System.out.println("An error occured");
                e.printStackTrace();
            }
        }
        public static void information() {
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Enter file Location(absolute location): ");
            String infolocation = scanner2.nextLine();
            File myObj = new File(infolocation);
            if(myObj.exists()) {
                System.out.println("File name: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());
                System.out.println("Writable: " + myObj.canWrite());
                System.out.println("Readable: " + myObj.canRead());
                System.out.println("File size in bytes: " + myObj.length());
            } else {
                System.out.println("File already exists");
            }
        }
        public static void writing() {
            Scanner scanner3 = new Scanner(System.in);
            try {
                System.out.print("Enter file location(absolute location): ");
                String writelocation = scanner3.nextLine();
                FileWriter myWriter = new FileWriter(writelocation);
                System.out.println("What do you want to write to the file? ");
                String writing = scanner3.nextLine();
                myWriter.write(writing);
                System.out.println("Done!");
                myWriter.close();
            } catch(IOException e) {
                System.out.println("En error occured");
                e.printStackTrace();
            }
        }
        public static void reading() {
            Scanner scanner4 = new Scanner(System.in);
            try {
                System.out.println("Enter file location(absolute location): ");
                String readlocation = scanner4.nextLine();
                File myObj = new File(readlocation);
                Scanner myReader = new Scanner(myObj);
                while(myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                    System.out.println("\nDone!");
                }
                myReader.close();
            } catch(IOException e) {
                System.out.println("An error occured");
                e.printStackTrace();
            }
        }
    
}
