/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project01;

//importing packages
import java.util.*;
import java.io.*;
import javax.swing.*;

//
public class Project01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Setting user input variable
        String choice;
        //Scanner
        Scanner object = new Scanner(System.in);

        //Set up to allow user to choose the file
        JFileChooser myChooser = new JFileChooser();
        myChooser.showOpenDialog(null);
        File netflixFile = myChooser.getSelectedFile();

        //File Scanner
        Scanner file = new Scanner(netflixFile);

        //User prompt while loop
        System.out.println("What would you like to do");
        System.out.println("Menu (Choose the following or Q to quit):");
        System.out.println("F -Filter on Type");
        System.out.println("D -Filter on Date");
        System.out.println("S -Search by show");
        System.out.println("H -Highest Days in Top Ten");
        System.out.print("Choice: ");
        choice = object.next();

        //While loop
        while (!"q".equals(choice)) {
            while (file.hasNext()) {
                //Puts data on array
                String[][] netflix = find(file);
                //Filters type of show/movie
                if ("f".equals(choice)) {
                    System.out.print("Would you like to filter on TV Show, Movie, or Stand-Up Comedy: ");
                    String typeChoice = object.next();
                    filterOnType(netflix, typeChoice);
                } //Searches for everything on the given date
                else if ("d".equals(choice)) {
                    System.out.print("What week would you like to search for (mm/dd/yyyy): ");
                    String dateChoice = object.next();
                    filterOnDate(netflix, dateChoice);
                } //Search for show
                else if ("s".equals(choice)) {
                    System.out.print("What TV Show or Movie would you like to search for: ");
                    String mediaChoice = object.next();
                    searchForShow(netflix, mediaChoice);

                } //Gives top 10
                else if ("h".equals(choice)) {
                    highestDaysInTopTen(netflix);
                } else {
                    System.out.println("Invalid Input");
                }

                System.out.println();
                System.out.println("What would you like to do");
                System.out.println("Menu (Choose the following or Q to quit):");
                System.out.println("F -Filter on Type");
                System.out.println("D -Filter on Date");
                System.out.println("S -Search by show");
                System.out.println("H -Highest Days in Top Ten");
                System.out.print("Choice: ");

            }
            choice = object.next();
        }
        //Closing File
        file.close();

    }

    public static String[][] find(Scanner fileInput) {
        String[][] netflixArray = new String[7101][6];
        while (fileInput.hasNextLine()) {
            for (int i = 0; i < netflixArray.length; i++) {
                String record = fileInput.nextLine();
                String[] line = record.split(",");
                netflixArray[i] = line;
            }
        }
        return netflixArray;
    }

    public static void searchForShow(String[][] dataSet, String show) throws FileNotFoundException {
        int count = 0;
        PrintWriter showFile = new PrintWriter("searchResults.txt");
        for (int i = 1; i < dataSet.length; i++) {
            if (dataSet[i][2] == show) {
                count++;
                showFile.printf("%-12s%-7s%-36s%-12s%-13s%-5s\n", dataSet[i][0], dataSet[i][1], dataSet[i][2], dataSet[i][3], dataSet[i][4], dataSet[i][5]);
            }
        }
        if (count > 0) {
            System.out.println("The number of weeks " + show + "appeared in: " + count);
        } else {
            System.out.println("Show not found");
        }
        showFile.close();
    }

    public static void filterOnType(String[][] dataSet, String type) throws FileNotFoundException {
        PrintWriter typeFile = new PrintWriter("type.txt");
        for (int i = 1; i < dataSet.length; i++) {
            if (dataSet[i][3] == type) {
                typeFile.printf("%-12s%-7s%-36s%-12s%-13s%-5s\n", dataSet[i][0], dataSet[i][1], dataSet[i][2], dataSet[i][3], dataSet[i][4], dataSet[i][5]);
            }
        }
        typeFile.close();
    }

    public static void filterOnDate(String[][] dataSet, String date) throws FileNotFoundException {
        PrintWriter showFile = new PrintWriter("date.txt");
        for (int i = 1; i < dataSet.length; i++) {
            if (dataSet[i][0] == date) {
                showFile.printf("%-12s%-7s%-36s%-12s%-13s%-5s\n", dataSet[i][0], dataSet[i][1], dataSet[i][2], dataSet[i][3], dataSet[i][4], dataSet[i][5]);
            }
        }
        showFile.close();
    }

    public static void highestDaysInTopTen(String[][] dataSet) {
        int max = 0;
        String maxShow = null;
        for (int i = 1; i < dataSet.length; i++) {
            if (Integer.parseInt(dataSet[i][5]) > max) {
                max = Integer.parseInt(dataSet[i][5]);
                maxShow = dataSet[i][2];
            }
        }
        System.out.println("The show/movie with the highest number of consecutive "
                + "days in the top ten is: " + maxShow + " with " + max + " days!");

    }

}
